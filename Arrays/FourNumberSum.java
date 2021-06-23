import java.util.*;

public class FourNumberSum {
    public static List<Integer[]> fourNumberSum(int[] arr, int target) {
        HashMap<Integer, List<Integer[]>> pairs = new HashMap<Integer, List<Integer[]>>();
        List<Integer[]> quadruplets = new ArrayList<Integer[]>();
        for (int i = 1; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                int currentSum = arr[i] + arr[j];
                int diff = target - currentSum;
                if (pairs.containsKey(diff)) {
                    for (Integer[] pair : pairs.get(diff)) {
                        Integer[] newQuad = { pair[0], pair[1], arr[i], arr[j] };
                        quadruplets.add(newQuad);
                    }
                }
            }
            for (int k = 0; k < i; k++) {
                int current = arr[i] + arr[k];
                Integer[] pair = { arr[k], arr[i] };
                if (!pairs.containsKey(current)) {
                    List<Integer[]> newPairs = new ArrayList<Integer[]>();
                    newPairs.add(pair);
                    pairs.put(current, newPairs);
                } else {
                    pairs.get(current).add(pair);
                }
            }
        }
        return quadruplets;
    }

    public static void main(String[] args) {
        int[] arr = { 7, 6, 4, -1, 1, 2 };

        List<Integer[]> result = fourNumberSum(arr, 16);
        Integer[][] res = new Integer[result.size()][4];
        for (int i = 0; i < result.size(); i++) {
            res[i] = result.get(i);
        }
        System.out.println(Arrays.deepToString(res));
    }
}
