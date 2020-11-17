import node.*;

public class Assembler {
    String output = "";

    public void assemble(Node node) {

        if (node instanceof Leaf) {

            this.setOutput(node.getValue() + " ");

        } else if (node instanceof Branch) {

            for(String id : node.getNodes().keySet() ) {

                assemble(node.getNodes().get(id));
            }
        }
    }

    public void setOutput(String text) {

        this.output += text;
    }

    public String getText() {
        return this.output;
    }
}
