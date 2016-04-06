package es.us.isa.ideas.synopsis.common.test;

import java.io.File;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import es.us.isa.FAMA.models.FAMAAttributedfeatureModel.AttributedFeature;
import es.us.isa.FAMA.models.FAMAAttributedfeatureModel.FAMAAttributedFeatureModel;
import es.us.isa.FAMA.models.FAMAAttributedfeatureModel.Relation;
import es.us.isa.FAMA.models.FAMAAttributedfeatureModel.fileformats.AttributedReader;
import es.us.isa.FAMA.models.FAMAAttributedfeatureModel.fileformats.AttributedWriter;
import es.us.isa.FAMA.models.featureModel.Cardinality;
import es.us.isa.FAMA.models.featureModel.GenericRelation;
import es.us.isa.FAMA.models.variabilityModel.VariabilityModel;
import es.us.isa.FAMA.parser.FMFParser;
import es.us.isa.aml.model.csp.CSPModel;
import es.us.isa.aml.model.csp.CSPObjectiveFunction;
import es.us.isa.aml.util.Util;
import es.us.isa.ideas.synopsis.common.AFMWriter;
import es.us.isa.ideas.synopsis.common.CSPGenerator;
import es.us.isa.ideas.synopsis.common.ParserHelper;
import es.us.isa.util.Node;
import es.us.isa.util.Tree;

public class Test {

    public static void main(String[] args) {
        // Test1();
        // Test2();

        String s = "// solution with objective 55" + "\n"
                + "VolumeStorage_totalCostMonth = 55;" + "\n"
                + "vol2_SimpleBlockStorage = 1;" + "\n"
                + "vol2_SimpleBlockStorage_volumeCostMonth = 15;" + "\n"
                + "vol2_SimpleBlockStorage_costGBMonth = 5;" + "\n"
                + "vol1_SimpleBlockStorage = 1;" + "\n"
                + "vol1_SimpleBlockStorage_volumeCostMonth = 40;" + "\n"
                + "vol1_SimpleBlockStorage_costGBMonth = 10;" + "\n"
                + "VolumeStorage = 1;" + "\n" + "VolumeStorage_discount = 0;"
                + "\n" + "vol1_Size = 1;" + "\n" + "vol1_Size_cardVar = 1;"
                + "\n" + "vol1_Size_1 = 0;" + "\n" + "vol1_Size_2 = 0;" + "\n"
                + "vol1_Size_3 = 0;" + "\n" + "vol1_Size_4 = 1;" + "\n"
                + "vol1_Size_5 = 0;" + "\n" + "vol1_SSD = 1;" + "\n"
                + "vol1_SSD_cardVar = 1;" + "\n" + "vol1_SSD_true = 1;" + "\n"
                + "vol1_SSD_false = 0;" + "\n" + "vol1_Region = 1;" + "\n"
                + "vol1_Region_cardVar = 1;" + "\n" + "vol1_Region_USA = 1;"
                + "\n" + "vol1_Region_EU = 0;" + "\n" + "vol1_Region_JP = 0;"
                + "\n" + "vol2_Size = 1;" + "\n" + "vol2_Size_cardVar = 1;"
                + "\n" + "vol2_Size_1 = 0;" + "\n" + "vol2_Size_2 = 0;" + "\n"
                + "vol2_Size_3 = 1;" + "\n" + "vol2_Size_4 = 0;" + "\n"
                + "vol2_Size_5 = 0;" + "\n" + "vol2_SSD = 1;" + "\n"
                + "vol2_SSD_cardVar = 1;" + "\n" + "vol2_SSD_true = 0;" + "\n"
                + "vol2_SSD_false = 1;" + "\n" + "vol2_Region = 1;" + "\n"
                + "vol2_Region_cardVar = 1;" + "\n" + "vol2_Region_USA = 1;"
                + "\n" + "vol2_Region_EU = 0;" + "\n" + "vol2_Region_JP = 0;";

        System.out.println(formatResult(s).toString());
    }

    public static void Test1() {
        try {
            InputStream in = Test.class
                    .getResourceAsStream("/VolumeStorage.hcs");
            String hcs = Util.getStringFromInputStream(in);

            in = Test.class.getResourceAsStream("/VolumeStorage.pref");
            String pref = Util.getStringFromInputStream(in);
            in.close();

            Map<String, Object> map = ParserHelper.parseHCS(hcs, pref);
            VariabilityModel vm = (VariabilityModel) map
                    .get("VariabilityModel");

            AFMWriter writer = new AFMWriter();

            String afm = writer.toString(vm);

            System.out
                    .println("===================== AFM Result =====================\n\n");
            System.out.println(afm);

            AttributedReader parser = new AttributedReader();
            FAMAAttributedFeatureModel afm2 = (FAMAAttributedFeatureModel) parser
                    .parseString(afm);

            CSPGenerator generator = new CSPGenerator();
            CSPModel cspModel = generator.generateOPL(afm);

            CSPObjectiveFunction objFunc = (CSPObjectiveFunction) map
                    .get("CSPObjectiveFunction");

            cspModel.setObjectiveFunction(objFunc);

            System.out.println("\n\n\n\nCSPModel : \n " + cspModel.toString());

            System.out.println(objFunc);

            File f = new File("test.afm");
            f.createNewFile();
            PrintWriter pw = new PrintWriter(f);
            pw.println(afm);
            pw.close();
        } catch (Exception e) {

        }
    }

    public static void Test2() {
        InputStream in = Test.class.getResourceAsStream("/VolumeStorage.afm");
        String content = Util.getStringFromInputStream(in);
        FMFParser parser = new FMFParser();
        FAMAAttributedFeatureModel afm = parser.parseModelFromString(content);

        AttributedWriter writer = new AttributedWriter();
        try {
            writer.writeFile("TestVolumeStorage.afm", afm);
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (GenericRelation r : afm.getRelations()) {
            if (r instanceof Relation) {
                Relation rel = (Relation) r;
                System.out.println(rel.getName() + ", "
                        + rel.getClass().getSimpleName());
                System.out.println("parent: "
                        + rel.getParent().getName()
                        + ", "
                        + rel.getParent().getDomain().getClass()
                        .getSimpleName());
                System.out.println("number of dest: "
                        + rel.getNumberOfDestination());
                Iterator<Cardinality> itCards = rel.getCardinalities();
                while (itCards.hasNext()) {
                    System.out.println("card: " + itCards.next());
                }
                Iterator<AttributedFeature> itDests = rel.getDestination();
                while (itDests.hasNext()) {
                    System.out.println("destinations: " + itDests.next());
                }

            }

            System.out.println("\n--------------------------");
        }
    }

    public static Tree<String> formatResult(Object object) {
        String result = object.toString();
        Tree<String> tree = new Tree<>();
        for (String line : result.split("\n")) {
            if (!line.startsWith("//")) {
                if (!line.contains("_")) {
                    String root = line.substring(0, line.indexOf("="));
                    tree.setRootElement(new Node<>(root));
                    break;
                }
            }
        }

        Map<String, Node<String>> map = new HashMap<>();

        for (String line : result.split("\n")) {
            if (!line.startsWith("//")) {
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
                        String[] aux2 = aux[1].split("=");
                        if (!aux2[1].trim().equals("0;")) {
                            tree.getRootElement().addChild(
                                    new Node<>(aux[1]));
                        }
                    }
                } else if (aux.length == 3) {
                    String[] aux2 = aux[2].split("=");
                    if (!aux2[1].trim().equals("0;")) {

                        if (!aux[1].equals("SimpleBlockStorage")) {
                            String res = aux[2].split("=")[0].trim();
                            if (res != null && !res.equals("cardVar")) {
                                subroot.addChild(new Node<>(aux[1]
                                        + " = " + res));
                            }
                        } else {
                            String conf = aux[2].split("=")[0].trim();
                            String res = aux[2].split("=")[1].trim();
                            subroot.addChild(new Node<>(conf + " = "
                                    + res));
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
}
