public class InvertBinaryTree {
    public static void invertBinaryTree(BinaryTree.Node tree) {
        BinaryTree.Node temp;
        if (!(tree == null)) {
            temp = tree.left;
            tree.left = tree.right;
            tree.right = temp;
        } else
            return;
        invertBinaryTree(tree.left);
        invertBinaryTree(tree.right);
    }
}
