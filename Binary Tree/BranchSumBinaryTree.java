import java.util.*;

public class BranchSumBinaryTree {
    public static List<Integer> branchSumBinaryTree(BinaryTree.Node tree) {
        List<Integer> sum = new ArrayList<Integer>();
        branchSum(tree, 0, sum);
        return sum;
    }

    public static void branchSum(BinaryTree.Node tree, int tempSum, List<Integer> sum) {
        int newSum = tempSum + tree.value;
        if (tree.left == null && tree.right == null) {
            sum.add(newSum);
            return;
        }
        branchSum(tree.left, newSum, sum);
        branchSum(tree.right, newSum, sum);
    }
}