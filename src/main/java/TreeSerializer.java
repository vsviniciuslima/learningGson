import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import node.Branch;
import node.Leaf;
import node.Node;

public class TreeSerializer {

    public Branch serializeTree(Node root) {

        RuntimeTypeAdapterFactory<Node> typeAdapterFactory = RuntimeTypeAdapterFactory
                .of(Node.class, "Node.Node Type")
                .registerSubtype(Branch.class, "Node.Branch")
                .registerSubtype(Leaf.class, "Node.Leaf");

        Gson modifiedGson = new GsonBuilder().registerTypeAdapterFactory(typeAdapterFactory).create();

        String output = modifiedGson.toJson(root);
        JsonObject test = (JsonObject) JsonParser.parseString(output);

//        GsonBuilder gsonBuilder = new GsonBuilder();
//        gsonBuilder.registerTypeAdapter(Node.Node.class, new NodeDeserializer());
//        Gson gson2 = gsonBuilder.create();

        return modifiedGson.fromJson(test, Branch.class);
    }
}
