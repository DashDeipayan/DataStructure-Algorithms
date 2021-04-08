public class ValidateBST {
    public static boolean validateBST(BinarySearchTree.Node tree){
        return validateBSThelper(tree,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }

    private static boolean validateBSThelper(BinarySearchTree.Node tree, int minValue, int maxValue) {
        if (tree==null) return true;
        if (tree.value<minValue || tree.value>=maxValue) return false;
        return validateBSThelper(tree.left, minValue, tree.value) 
            && validateBSThelper(tree.right, tree.value, maxValue);       
    }
}
