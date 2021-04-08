public class BinarySearchTree {
    class Node {
        int value;
        Node left, right;
		//Making a class for node
        public Node(int value) {
            this.value = value;
            left = right = null;
        }
    }
    Node root;

	//Constructor
    BinarySearchTree() {
        root = null;
    }

	//Helper function for inserting node
    public Node insertNode(Node root, int value) {
        if (root == null) {			
            root = new Node(value);			//set up root if empty prior
            return root;
        }
        if(value<root.value){				//Following property of BST
            root.left = insertNode(root.left, value);
        }
        else{
            root.right = insertNode(root.right, value);
        }
        return root;
    }

	//Helper function for node contains
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

	//Helper function for deleting a node and reconstructing the BST 
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
            root.value = inOrderSuccessor(root.right);			//Find the inorder successor and replace with
            root.right = deleteNode(root.value, root.right);	//deleted node
        }
        return root;
    }

	//functio to find inorder successor
    private int inOrderSuccessor(Node root) {
        int minimumValue = root.value;
        while(root.left != null){
            minimumValue = root.left.value;
            root = root.left;
        }
        return minimumValue;
    }

	//Helper function for inorder inorder traversal
    public void inOrderTraversal(Node root){
        if(root != null){
            inOrderTraversal(root.left);
            System.out.print(root.value+", ");
            inOrderTraversal(root.right);
        }
    }

	//Main function for inserting a node into the BinarySearchTree
    void insert(int value){
        root = insertNode(root,value);
    }

	//Main function for checking a node in BST
    void contains(int value){
        System.out.println("\nTree contains "+value+" = "+containsNode(root,value));  
    }

	//Main function for deleting a node from the BinarySearchTree
    void delete(int value){
        System.out.println("\nDeleting node with value "+value);
        root = deleteNode(value,root);
    }

	//Main function for inorder traversal of the tree
    void traverse(){
        inOrderTraversal(root);
    }

	//Main function for finding the closest Value in BST
    int findClosest(int target){
        return FindClosestValue.findClosestValue(root,target);
    }

    void isValidBST(){
        if(ValidateBST.validateBST(root))
            System.out.println("This is a Binary Search Tree");
        else
            System.out.println("This is not a Binary Search Tree");
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

        int closest = tree.findClosest(23);
        System.out.println("\nClosest value for 23 is "+closest);
        
        tree.isValidBST();
    }
}
