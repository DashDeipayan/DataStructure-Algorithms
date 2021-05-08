import java.util.*;

public class BreadthFirstSearch {
    static class Node {
        String name;
        List<Node> child = new ArrayList<>();

        public Node(String name) {
            this.name = name;
        }

        public Node addChild(String name) {
            Node newChild = new Node(name);
            child.add(newChild);
            return this;
        }

        public List<String> breadthFirstSearch(List<String> array) {
            Queue<Node> queue = new LinkedList<>();
            queue.add(this);
            while (!queue.isEmpty()) {
                Node current = queue.remove();
                array.add(current.name);
                queue.addAll(current.child);
            }
            return array;
        }
    }

    public static void main(String[] args) {
        BreadthFirstSearch.Node bfs = new BreadthFirstSearch.Node("A");
        bfs.addChild("B");
        bfs.addChild("C");
        bfs.addChild("D");
        bfs.addChild("E");
        bfs.child.get(0).addChild("F");
        bfs.child.get(1).addChild("G");
        bfs.child.get(0).addChild("H");
        bfs.child.get(2).addChild("I");
        bfs.child.get(0).child.get(0).addChild("J");
        bfs.child.get(0).child.get(1).addChild("K");
        bfs.child.get(1).child.get(0).addChild("L");
        bfs.child.get(2).child.get(0).addChild("M");

        ArrayList<String> array = new ArrayList<String>();
        System.out.println(bfs.breadthFirstSearch(array));
    }
}
