import node.Branch;
import node.Leaf;
import node.Node;
import com.google.gson.*;

public class learningJson {

    public static void main(String[] args) {

        //serializeUserSimple();
        //deserializeUserSimple();

        //System.out.println("learningGson 2.0");
        //serializeUserNested();
        //deserializeUserNested();

        Gson gson = new Gson();

        Branch root = createNode();
        assemble(root);

        Branch newRoot = serializeTree(root);
        assemble(newRoot);

        String output = serializeTreeToString(root);


        String rootOutput = gson.toJson(root);
        String newRootOutput = gson.toJson(newRoot);
    }

    private static Branch createNode() {

        Branch root = new Branch();
        Branch branch1 = new Branch();
        Branch branch2 = new Branch();


        root.addNode(new Leaf("Novo texto"));
        root.addNode(branch1);

        branch1.addNode(new Leaf("de exemplo"));
        branch1.addNode(new Leaf("para"));
        branch1.addNode(branch2);

        branch2.addNode(new Leaf("assemble"));
        branch2.addNode(new Leaf("do documento. Horário: 14:10"));

        return root;
    }

    public static void assemble(Node root) {

        Assembler documentAssembler = new Assembler();

        documentAssembler.assemble(root);
        System.out.println(documentAssembler.getText());
    }

    private static Branch serializeTree(Node root) {

        RuntimeTypeAdapterFactory<Node> typeAdapterFactory = RuntimeTypeAdapterFactory
                .of(Node.class, "Node.Node Type")
                .registerSubtype(Branch.class, "Node.Branch")
                .registerSubtype(Leaf.class, "Node.Leaf");

        Gson modifiedGson = new GsonBuilder().registerTypeAdapterFactory(typeAdapterFactory).create();

        String output = modifiedGson.toJson(root);
        JsonObject jsonObjectOutput = (JsonObject) JsonParser.parseString(output);

//        GsonBuilder gsonBuilder = new GsonBuilder();
//        gsonBuilder.registerTypeAdapter(Node.Node.class, new NodeDeserializer());
//        Gson gson2 = gsonBuilder.create();

        return modifiedGson.fromJson(jsonObjectOutput, Branch.class);
    }

    private static String serializeTreeToString(Node root) {

        RuntimeTypeAdapterFactory<Node> typeAdapterFactory = RuntimeTypeAdapterFactory
                .of(Node.class, "Node.Node Type")
                .registerSubtype(Branch.class, "Node.Branch")
                .registerSubtype(Leaf.class, "Node.Leaf");

        Gson modifiedGson = new GsonBuilder().registerTypeAdapterFactory(typeAdapterFactory).create();

        return modifiedGson.toJson(root);
    }
}
