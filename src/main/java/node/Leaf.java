package node;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public class Leaf extends Node {

    public Leaf(String value) {
        this.setValue(value);
    }
    public Leaf() {
    }

    @Override
    public LinkedHashMap<String, Node> getNodes() {
        return null;
    }
}
