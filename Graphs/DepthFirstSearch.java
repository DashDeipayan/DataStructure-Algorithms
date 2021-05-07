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
        DepthFirstSearch.Node dfs = new DepthFirstSearch.Node("A");
        dfs.addChild("B");
        dfs.addChild("C");
        dfs.addChild("D");
        dfs.addChild("E");
        dfs.child.get(0).addChild("F");
        dfs.child.get(1).addChild("G");
        dfs.child.get(0).addChild("H");
        dfs.child.get(2).addChild("I");
        dfs.child.get(0).child.get(0).addChild("J");
        dfs.child.get(0).child.get(1).addChild("K");
        dfs.child.get(1).child.get(0).addChild("L");
        dfs.child.get(2).child.get(0).addChild("M");
        ArrayList<String> array = new ArrayList<String>();
        System.out.println(dfs.depthFirstSearch(array));
    }
}