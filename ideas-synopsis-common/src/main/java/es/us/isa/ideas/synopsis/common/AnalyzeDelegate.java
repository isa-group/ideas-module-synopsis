/**
 * 
 */
package es.us.isa.ideas.synopsis.common;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import es.us.isa.FAMA.models.variabilityModel.VariabilityModel;
import es.us.isa.aml.model.csp.CSPModel;
import es.us.isa.aml.model.csp.CSPObjectiveFunction;
import es.us.isa.aml.reasoners.CSPWebReasoner;
import es.us.isa.aml.util.Config;
import es.us.isa.aml.util.OperationResponse;
import es.us.isa.aml.util.Util;
import es.us.isa.ideas.common.AppResponse;
import es.us.isa.ideas.common.AppResponse.Status;
import es.us.isa.util.Node;

/**
 * @author jdelafuente
 *
 */
public class AnalyzeDelegate {

	public static void LoadConf() {
		InputStream in = AnalyzeDelegate.class
				.getResourceAsStream("/config.json");
		String config = Util.getStringFromInputStream(in);
		Config.load(config);
	}

	public static AppResponse analize(String id, String content,
			String fileUri, String auxArg0) {

		LoadConf();
		AppResponse appResponse = new AppResponse();

		try {
			if (id.equals("generateAFM")) {
				try {
					Map<String, Object> map = ParserHelper.parseHCS(content,
							auxArg0);
					VariabilityModel vm = (VariabilityModel) map
							.get("VariabilityModel");
					AFMWriter writer = new AFMWriter();
					String data = writer.toString(vm);
					appResponse.setData(data);
					appResponse
							.setMessage("<pre><b>The AFM document has been generated successfully.</b></pre>");
					String newURI = constructUri(fileUri, "afm");
					appResponse.setFileUri(newURI);
					appResponse.setStatus(Status.OK);
				} catch (Exception e) {
					appResponse.setMessage("<pre>There was an error.</pre>");
					appResponse.setStatus(Status.ERROR);
					e.printStackTrace();
				}
			} else if (id.equals("generateOPL")) {
				try {
					Map<String, Object> map = ParserHelper.parseHCS(content,
							auxArg0);
					VariabilityModel vm = (VariabilityModel) map
							.get("VariabilityModel");
					AFMWriter writer = new AFMWriter();
					String vm_data = writer.toString(vm);
					if (!vm_data.isEmpty()) {
						CSPGenerator generator = new CSPGenerator();
						CSPModel cspModel = generator.generateOPL(vm_data);
						cspModel.setUseCP(false);
						if (cspModel != null) {
							CSPObjectiveFunction objFunc = (CSPObjectiveFunction) map
									.get("CSPObjectiveFunction");
							if (objFunc != null)
								cspModel.setObjectiveFunction(objFunc);
							appResponse.setData(cspModel.toString());
							appResponse
									.setMessage("<pre><b>The OPL document has been generated successfully.</b></pre>");
							String newURI = constructUri(fileUri, "opl");
							appResponse.setFileUri(newURI);
							appResponse.setStatus(Status.OK);
						}
					} else {
						appResponse
								.setMessage("<pre>There was an error.</pre>");
						appResponse.setStatus(Status.ERROR);
					}
				} catch (Exception e) {
					appResponse.setMessage("<pre>There was an error.</pre>");
					appResponse.setStatus(Status.ERROR);
					e.printStackTrace();
				}
			} else if (id.equals("getOptimalConfiguration")) {
				try {
					Map<String, Object> map = ParserHelper.parseHCS(content,
							auxArg0);

					if (map.get("Errors") != null) {
						appResponse
								.setMessage("<pre><b>The document contains the following errors:</b>\n"
										+ map.get("Errors") + "</pre>");
						appResponse.setStatus(Status.OK_PROBLEMS);
					} else {
						StringBuilder message = new StringBuilder();
						if (map.get("Warnings") != null)
							message.append("<pre> Warnings: \n" + map.get("Warnings")
									+ "</pre>\n");

						VariabilityModel vm = (VariabilityModel) map
								.get("VariabilityModel");
						AFMWriter writer = new AFMWriter();
						String vm_data = writer.toString(vm);
						if (!vm_data.isEmpty()) {
							CSPGenerator generator = new CSPGenerator();
							CSPModel cspModel = generator.generateOPL(vm_data);
							cspModel.setUseCP(false);
							if (cspModel != null) {
								CSPObjectiveFunction objFunc = (CSPObjectiveFunction) map
										.get("CSPObjectiveFunction");
								if (objFunc != null)
									cspModel.setObjectiveFunction(objFunc);

								String cspModelData = cspModel.toString();

								CSPWebReasoner webReasoner = new CSPWebReasoner();
								Boolean solve = webReasoner.solve(cspModelData);
								OperationResponse op = webReasoner
										.explain(cspModelData);

								if (solve) {
									Tree<String> tree_result = formatResult(op
											.get("result"));
									String result = tree_result.printTree();

									message.append("<pre><b>Optimal Configuration calculated:</b>\n"
											+ result + "</pre>");
									appResponse.setStatus(Status.OK);
								} else {
									if (op.getResult().get("conflicts") != null) {
										message.append("<pre><b>The document is not consistent.</b>\n"
												+ op.getResult().get(
														"conflicts") + "</pre>");
										appResponse
												.setStatus(Status.OK_PROBLEMS);
									} else {
										message.append("<pre><b>The document contains errors.</b>\n"
												+ "</pre>");
										appResponse
												.setStatus(Status.OK_PROBLEMS);
									}
								}

								appResponse.setMessage(message.toString());

								appResponse.setFileUri(fileUri);
							}
						} else {
							appResponse
									.setMessage("<pre>There was an error.</pre>");
							appResponse.setStatus(Status.ERROR);
						}
					}
				} catch (Exception e) {
					appResponse.setMessage("<pre>There was an error.</pre>");
					appResponse.setStatus(Status.ERROR);
					e.printStackTrace();
				}
			}
		} catch (Exception e) {

		}

		return appResponse;
	}

	public static Tree<String> formatResult(Object object) {
		String result = object.toString();		
		Tree<String> tree = new Tree<String>();
		for (String line : result.split("\n")) {
			if (!line.startsWith("//") && !line.isEmpty()) {
				if (!line.contains("_")) {
					String root = line.substring(0, line.indexOf("="));
					tree.setRootElement(new Node<String>(root));
					break;
				}
			}
		}

		Map<String, Node<String>> map = new HashMap<String, Node<String>>();

		for (String line : result.split("\n")) {
			if (!line.startsWith("//") && !line.isEmpty()) {
				String[] aux = line.split("_");

				Node<String> subroot;
				if (map.get(aux[0].trim()) != null)
					subroot = map.get(aux[0]);
				else
					subroot = new Node<String>(aux[0]);

				if (aux.length == 2) {
					if (subroot.getData().equals(
							tree.getRootElement().getData().trim())) {
						String[] aux2 = aux[1].split(" = ");
						if (!aux2[1].equals("0;")) {
							try {
								Integer e = Integer.valueOf(aux2[1].replace(
										";", ""));
								Double d = (double) (e / 100.0);
								String r = aux2[0] + " = " + d;
								tree.getRootElement().addChild(
										new Node<String>(r));
							} catch (NumberFormatException e) {
								tree.getRootElement().addChild(
										new Node<String>(aux[1]
												.replace(";", "")));
							}
						}
					}
				} else if (aux.length == 3) {
					String[] aux2 = aux[2].split(" = ");
					if (!aux2[1].equals("0;")) {
						if (!aux[1].equals("SimpleBlockStorage")) {
							String res = aux2[0];
							if (res != null && !res.equals("cardVar")) {
								subroot.addChild(new Node<String>(aux[1]
										+ " = " + res.replace(";", "")));
							}
						} else {
							String conf = aux2[0];
							String res = aux2[1].replace(";", "");
							try {
								Integer e = Integer.valueOf(res);
								Double d = (double) (e / 100.0);
								subroot.addChild(new Node<String>(conf + " = "
										+ d));
							} catch (NumberFormatException e) {
								subroot.addChild(new Node<String>(conf + " = "
										+ res));
							}
						}
					}
				}

				if (!tree.toList().contains(subroot)) {
					if (!subroot.getData().equals("VolumeStorage = 1;")) {
						tree.getRootElement().addChild(subroot);
						map.put(aux[0].trim(), subroot);
					}
				}
			}
		}

		return tree;
	}

	private static String constructUri(String uri, String extension) {
		String ret = "";
		String[] listUri = uri.split("/");
		String file = listUri[listUri.length - 1];

		String[] fileaux = file.split("\\.");
		String filename = fileaux[0];

		for (int i = 0; i < listUri.length - 1; i++) {
			ret += listUri[i] + "/";
		}
		ret += filename + "." + extension;
		return ret;
	}

	@Override
	public String toString() {
		return "AnalyzerDelegate - v1.0.0";
	}

}
