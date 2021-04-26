public class NodeDepth {
    public static int nodeDepth(BinaryTree.Node node) {
        return nodeDepthForRoot(node, 0);
    }

    private static int nodeDepthForRoot(BinaryTree.Node node, int height) {
        if (node == null) {
            return 0;
        }
        return height + nodeDepthForRoot(node.left, height + 1) + nodeDepthForRoot(node.right, height + 1);
    }
}
