import java.util.*;

public class TwoNumberSum {
    public static void twoNumberSum(Integer[] array, Integer sum) {
        HashMap<Integer, Integer> findPair = new HashMap<>();
        Integer size = array.length;
        for (Integer i = 0; i < size; i++) {
            Integer currentNum = array[i];
            if (findPair.containsKey(sum - currentNum)) {
                Integer y = sum - currentNum;
                // int[] tempArray = {currentNum, y};
                System.out.println("[" + findPair.get(y) + "," + i + "]");
            } else {
                findPair.put(currentNum, i);
            }
        }
    }

    public static void main(String[] args) {
        Integer[] arr1 = { 3, 5, -4, 8, 11, 1, -1, 6 };
        Integer sum = 10;
        twoNumberSum(arr1, sum);
    }
}
