public class BinarySearchTree {
    class Node {
        int value;
        Node left, right;

        public Node(int value) {
            this.value = value;
            left = right = null;
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
        if(value<=root.value){
            root.left = insertNode(root.left, value);
        }
        else{
            root.right = insertNode(root.right, value);
        }
        return root;
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

    public Node deleteNode(int value, Node root){
        if(root == null)
            return root;
        if(value < root.value){
            root.left = deleteNode(value,root.left);
        }
        else if(value > root.value){
            root.right = deleteNode(value,root.right);
        }
        else{
            if(root.left == null){
                return root.right;
            }
            else if(root.right == null){
                return root.left;
            }
            root.value = inOrderSuccessor(root.right);
            root.right = deleteNode(root.value, root.right);
        }
        return root;
    }

    private int inOrderSuccessor(Node root) {
        int minimumValue = root.value;
        while(root.left != null){
            minimumValue = root.left.value;
            root = root.left;
        }
        return minimumValue;
    }

    public void inOrderTraversal(Node root){
        if(root != null){
            inOrderTraversal(root.left);
            System.out.print(root.value+", ");
            inOrderTraversal(root.right);
        }
    }

    void insert(int value){
        root = insertNode(root,value);
    }
    void contains(int value){
        System.out.println("\nTree contains "+value+" = "+containsNode(root,value));  
    }
    void delete(int value){
        System.out.println("\nDeleting node with value "+value);
        root = deleteNode(value,root);
    }
    void traverse(){
        inOrderTraversal(root);
    }


    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        
        tree.insert(50);
        tree.insert(21);
        tree.insert(9);
        tree.insert(56);
        tree.insert(25);
        tree.insert(15);
        tree.insert(8);
        tree.insert(7);
        tree.insert(6);
        tree.insert(4);
        tree.insert(3);
        tree.insert(30);
        tree.insert(1);

        tree.traverse();
        tree.contains(15);

        tree.delete(15);
        tree.contains(15);
        tree.traverse();
    }
}
