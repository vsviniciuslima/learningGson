package node;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.UUID;

public abstract class Node {
    String id;
    String value;
    LinkedHashMap<String, Node> nodes = new LinkedHashMap<>();

    public Node(String value, LinkedHashMap<String, Node> nodes) {
        this.value = value;
        this.nodes = nodes;
    }

    public Node() {
        this.id = UUID.randomUUID().toString();
    }


    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public LinkedHashMap<String, Node> getNodes() {
        return nodes;
    }

    public void setNodes(LinkedHashMap<String, Node> nodes) {
        this.nodes = nodes;
    }

    public void addNode(Node child) {
        this.nodes.put(child.getId(), child);
    }

    public String getId() {
        return this.id;
    }
}
