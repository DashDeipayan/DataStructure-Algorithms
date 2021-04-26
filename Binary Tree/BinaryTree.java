import java.util.*;

public class BinaryTree {

    class Node {
        int value;
        Node left, right;

        public Node(int value) {
            this.value = value;
            left = right = null;
        }
    }

    Node root;

    public BinaryTree() {
        root = null;
    }

    public BinaryTree(int value) {
        root = new Node(value);
    }

    public Node insertHelper(Node temp, int value) {
        Queue<Node> queue = new LinkedList<>();
        if (temp == null) {
            root = new Node(value);
            return temp;
        }
        queue.add(temp);
        while (!queue.isEmpty()) {
            temp = queue.peek();
            queue.remove();
            if (temp.left == null) {
                temp.left = new Node(value);
                break;
            } else {
                queue.add(temp.left);
            }
            if (temp.right == null) {
                temp.right = new Node(value);
                break;
            } else {
                queue.add(temp.right);
            }
        }
        return temp;
    }

    public void printTreeHelper(Node temp) {
        if (temp != null) {
            printTreeHelper(temp.left);
            System.out.print(temp.value + ", ");
            printTreeHelper(temp.right);
        }
    }

    public void insert(int value) {
        insertHelper(root, value);
    }

    public void printTree() {
        printTreeHelper(root);
    }

    public void getBranchSum() {
        System.out.println("\n" + BranchSumBinaryTree.branchSumBinaryTree(root));
    }

    public void getNodeDepthSum() {
        System.out.println("\n" + NodeDepth.nodeDepth(root));
    }

    public void invertTree() {
        InvertBinaryTree.invertBinaryTree(root);
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree(5);
        tree.insert(10);
        tree.insert(14);
        tree.insert(11);
        tree.insert(15);
        tree.insert(18);
        tree.insert(9);
        tree.insert(61);
        tree.insert(31);
        tree.insert(70);
        tree.insert(45);
        tree.insert(24);
        tree.insert(43);
        tree.insert(3);
        tree.insert(21);

        tree.printTree();

        tree.getBranchSum();

        tree.getNodeDepthSum();

        tree.invertTree();
        tree.printTree();
    }
}
