public class FindClosestValue {

    public static int findClosestValue(BinarySearchTree.Node tree, int number){
        return findClosestValueinBST(tree, number, Integer.MAX_VALUE);
    }

    private static int findClosestValueinBST(BinarySearchTree.Node tree, int number, int closestValue) {
        if (tree == null){
            return closestValue;
        }
        if(Math.abs(number-closestValue)>Math.abs(number-tree.value)){
            closestValue = tree.value;
        }
        if(number < tree.value){
            return findClosestValueinBST(tree.left,number,closestValue);
        }
        else if(number > tree.value){
            return findClosestValueinBST(tree.right,number,closestValue);
        }
        else{
            return closestValue;
        }
    }
    
}
