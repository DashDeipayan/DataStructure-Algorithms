public class BinarySearchTree {
    class Node {
        int value;
        Node left, right;

        public Node(int value) {
            this.value = value;
            left = right = null;
        }

        public void deleteNode(int value2, BinarySearchTree.Node currentNode) {
        }
    }

    Node root;

    BinarySearchTree() {
        root = null;
    }

    public Node insertNode(Node root, int value) {
        if (root == null) {
            root = new Node(value);
            return root;
        }
        Node currentNode = root;
        while (true) {
            if (value < currentNode.value) {
                if (currentNode.left == null) {
                    currentNode.left = new Node(value);
                    break;
                } else {
                    currentNode = currentNode.left;
                }
            } else {
                if (currentNode.right == null) {
                    currentNode.right = new Node(value);
                    break;
                } else {
                    currentNode = currentNode.right;
                }
            }
        }
        return currentNode;
    }

    public Boolean containsNode(Node root, int value) {
        if (root == null) {
            return false;
        }
        Node currentNode = root;
        while (currentNode != null) {
            if (value < currentNode.value) {
                currentNode = currentNode.left;
            } else if (value > currentNode.value) {
                currentNode = currentNode.right;
            } else {
                return true;
            }
        }
        return false;
    }

    public Node deleteNode(int value, Node parentNode){
        Node currentNode = root;
        while (currentNode != null){
            if(value < currentNode.value){
                parentNode = currentNode;
                currentNode = currentNode.left;
            }
            else if (value >currentNode.value){
                parentNode = currentNode;
                currentNode = currentNode.right;
            }
            else{
                if(currentNode.left == null&&currentNode.right==null){
                    currentNode.value = currentNode.right.minValue();
                    currentNode.right.deleteNode(currentNode.value, currentNode);
                }
            //To Be Updated
            }
        }
    }
}