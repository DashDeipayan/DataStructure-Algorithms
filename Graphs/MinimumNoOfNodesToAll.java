import java.util.*;

public class MinimumNoOfNodesToAll {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        List<Integer> resultArray = new ArrayList<>();
        int[] visitedNode = new int[n];
        for (List<Integer> edge : edges) {
            visitedNode[edge.get(1)] = 1;
        }
        for (int i = 0; i < n; i++) {
            if (visitedNode[i] == 0) {
                resultArray.add(i);
            }
        }
        return resultArray;
    }

    public static void main(String[] args) {

    }
}
