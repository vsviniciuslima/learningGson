import com.google.gson.*;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class learningJson {

    public static void main(String[] args) {

        //serializeUserSimple();
        //deserializeUserSimple();

        //System.out.println("learningGson 2.0");
        //serializeUserNested();
        //deserializeUserNested();

        Branch root = createNode();
        assemble(root);

        serializeTree(root);

        Branch newRoot = serializeTree(root);
        assemble(newRoot);

        Gson gson = new Gson();

        String rootOutput = gson.toJson(root);
        String newRootOutput = gson.toJson(newRoot);
    }

    private static void serializeUserSimple() {

        UserSimple user = new UserSimple(
                "Vinicius",
                "vsviniciuslima@gmail.com",
                20,
                true
                );

        Gson gson = new Gson();

        String json = gson.toJson(user);

    }
    private static void deserializeUserSimple() {
        String source = "{\n" +
                "  \"name\": \"Guilherme\",\n" +
                "  \"email\": \"gsguilhermelima@gmail.com\",\n" +
                "  \"age\": 23,\n" +
                "  \"isDeveloper\": false\n" +
                "}";

        Gson gson = new Gson();

        UserSimple user2 = gson.fromJson(source, UserSimple.class);
    }

    private static void serializeUserNested() {

        UserAddress adress = new UserAddress(
                "Main Street",
                "64",
                "Madgeburg",
                "Germany"
        );

        UserNested userNested = new UserNested(
                "Vinicius",
                "vsviniciuslima@gmail.com",
                20,
                true,
                adress
        );

        String json = new Gson().toJson(userNested);
    }
    private static void deserializeUserNested() {
        String restaurantJson = "{\n" +
                "  \"name\": \"Future Studio Steakhouse\",\n" +
                "  \"owner\": {\n" +
                "    \"name\": \"Christian\",\n" +
                "    \"address\": {\n" +
                "      \"city\": \"Madgeburg\",\n" +
                "      \"country\": \"Germany\",\n" +
                "      \"houseNumber\": \"42A\",\n" +
                "      \"street\": \"Main Street\"\n" +
                "    }\n" +
                "  },\n" +
                "  \"cook\": {\n" +
                "    \"age\": 18,\n" +
                "    \"name\": \"Marcus\",\n" +
                "    \"salary\": 1500\n" +
                "  },\n" +
                "  \"waiter\": {\n" +
                "    \"age\": 18,\n" +
                "    \"name\": \"Norman\",\n" +
                "    \"salary\": 1000\n" +
                "  }\n" +
                "}";

        Restaurant restaurant = new Gson().fromJson(restaurantJson, Restaurant.class);
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
        branch2.addNode(new Leaf("do documento. Horário: 12:18"));

        return root;
    }

    public static void assemble(Node root) {

        Assembler documentAssembler = new Assembler();

        documentAssembler.assemble(root);
        System.out.println(documentAssembler.getText());
    }

    private static Branch serializeTree(Node root) {

        RuntimeTypeAdapterFactory<Node> typeAdapterFactory = RuntimeTypeAdapterFactory
                .of(Node.class, "Node Type")
                .registerSubtype(Branch.class, "Branch")
                .registerSubtype(Leaf.class, "Leaf");

        Gson modifiedGson = new GsonBuilder().registerTypeAdapterFactory(typeAdapterFactory).create();

        String output = modifiedGson.toJson(root);
        JsonObject test = (JsonObject) JsonParser.parseString(output);

//        GsonBuilder gsonBuilder = new GsonBuilder();
//        gsonBuilder.registerTypeAdapter(Node.class, new NodeDeserializer());
//        Gson gson2 = gsonBuilder.create();

        return modifiedGson.fromJson(test, Branch.class);
    }
}
