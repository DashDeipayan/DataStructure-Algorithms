import java.util.*;

public class MinimumNoOfNodesToAll {
    public static List<Integer> findSmallestSetOfVertices(int n, List<ArrayList<Integer>> edges) {
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
        int[][] array = { { 0, 1 }, { 0, 2 }, { 2, 5 }, { 3, 4 }, { 4, 2 } };
        List<ArrayList<Integer>> edges = new ArrayList<ArrayList<Integer>>();
        for (int[] value : array) {
            ArrayList<Integer> temp = new ArrayList<>();
            temp.add(value[0]);
            temp.add(value[1]);
            edges.add(temp);
        }
        System.out.println(findSmallestSetOfVertices(6, edges));
    }
}
