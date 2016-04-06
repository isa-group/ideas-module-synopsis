/**
 *
 */
package es.us.isa.ideas.synopsis.common;

import es.us.isa.FAMA.models.variabilityModel.VariabilityModel;
import es.us.isa.aml.model.csp.CSPModel;
import es.us.isa.aml.model.csp.CSPObjectiveFunction;
import es.us.isa.aml.reasoners.cspwebreasoner.CSPWebReasoner;
import es.us.isa.aml.reasoners.cspwebreasoner.Solution;
import es.us.isa.aml.util.Config;
import es.us.isa.aml.util.Util;
import es.us.isa.ideas.module.common.AppResponse;
import es.us.isa.ideas.module.common.AppResponse.Status;
import es.us.isa.util.Node;
import java.io.InputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

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
            switch (id) {
                case "generateAFM":
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
                    }
                    break;
                case "generateOPL":
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
                                if (objFunc != null) {
                                    cspModel.setObjectiveFunction(objFunc);
                                }
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
                    }
                    break;
                case "getOptimalConfiguration":
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
                            if (map.get("Warnings") != null) {
                                message.append("<pre> Warnings: \n").append(map.get("Warnings")).append("</pre>\n");
                            }

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
                                    if (objFunc != null) {
                                        cspModel.setObjectiveFunction(objFunc);
                                    }

                                    CSPWebReasoner webReasoner = new CSPWebReasoner();
                                    Solution sol = webReasoner.explain(cspModel);

                                    if (sol.getError() != null) {
                                        appResponse.setMessage("<pre>There was an operation error: " + sol.getError() + "</pre>");
                                        appResponse.setStatus(Status.OK_PROBLEMS);
                                    } else {
                                        Boolean solve = sol.getFeasibility();
                                        if (solve) {
                                            Tree<String> tree_result = formatResult(sol.getExplaining());
                                            String result = tree_result.printTree();

                                            message.append("<pre><b>Optimal Configuration calculated:</b>\n").append(result).append("</pre>");
                                            appResponse.setStatus(Status.OK);
                                        } else if (sol.getConflicts() != null && !sol.getConflicts().isEmpty()) {
                                            message.append("<pre><b>The document is not consistent.</b>\n").append(Arrays.toString(sol.getConflicts().toArray())).append("</pre>");
                                            appResponse
                                                    .setStatus(Status.OK_PROBLEMS);
                                        } else {
                                            message.append("<pre><b>The document contains errors.</b>\n"
                                                    + "</pre>");
                                            appResponse.setStatus(Status.OK_PROBLEMS);
                                        }

                                        appResponse.setMessage(message.toString());

                                        appResponse.setFileUri(fileUri);
                                    }
                                }
                            } else {
                                appResponse
                                        .setMessage("<pre>There was a problem parsing the HCS/PREF file. Please, review the syntaxes of these files.</pre>");
                                appResponse.setStatus(Status.OK_PROBLEMS);
                            }
                        }
                    } catch (Exception e) {
                        appResponse.setMessage("<pre>There was an error.</pre>");
                        appResponse.setStatus(Status.ERROR);
                    }
                    break;
                default:
                    break;
            }
        } catch (Exception e) {

        }

        return appResponse;
    }

    public static Tree<String> formatResult(Object object) {
        String result = object.toString();
        Tree<String> tree = new Tree<>();
        for (String line : result.split("\n")) {
            if (!line.startsWith("//") && !line.isEmpty()) {
                if (!line.contains("_")) {
                    String root = line.substring(0, line.indexOf("="));
                    tree.setRootElement(new Node<>(root));
                    break;
                }
            }
        }

        Map<String, Node<String>> map = new HashMap<>();

        for (String line : result.split("\n")) {
            if (!line.startsWith("//") && !line.isEmpty()) {
                String[] aux = line.split("_");

                Node<String> subroot;
                if (map.get(aux[0].trim()) != null) {
                    subroot = map.get(aux[0]);
                } else {
                    subroot = new Node<>(aux[0]);
                }

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
                                        new Node<>(r));
                            } catch (NumberFormatException e) {
                                tree.getRootElement().addChild(
                                        new Node<>(aux[1]
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
                                subroot.addChild(new Node<>(aux[1]
                                        + " = " + res.replace(";", "")));
                            }
                        } else {
                            String conf = aux2[0];
                            String res = aux2[1].replace(";", "");
                            try {
                                Integer e = Integer.valueOf(res);
                                Double d = (double) (e / 100.0);
                                subroot.addChild(new Node<>(conf + " = "
                                        + d));
                            } catch (NumberFormatException e) {
                                subroot.addChild(new Node<>(conf + " = "
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
