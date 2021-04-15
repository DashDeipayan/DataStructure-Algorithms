import java.util.*;

public class DepthFirstSearch {
    static class Node {
        String name;
        List<Node> child = new ArrayList<Node>();

        public Node(String name) {
            this.name = name;
        }

        public Node addChild(String name) {
            Node newChild = new Node(name);
            child.add(newChild);
            return this;
        }

        public List<String> depthFirstSearch(List<String> array) {
            array.add(this.name);
            for (int i = 0; i < child.size(); i++) {
                child.get(i).depthFirstSearch(array);
            }
            return array;
        }
    }

    public static void main(String[] args) {

    }
}