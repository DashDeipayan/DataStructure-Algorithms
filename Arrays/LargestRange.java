import java.util.*;

public class LargestRange {
    public static int[] largestRange(int[] array) {
        int[] largestrng = new int[2];
        int rangelength = 0;
        HashMap<Integer, Boolean> numMap = new HashMap<Integer, Boolean>();
        for (int num : array) {
            numMap.put(num, true);
        }
        for (int num : array) {
            if (!numMap.get(num))
                continue;
            numMap.put(num, false);
            int templength = 1;
            int left = num - 1;
            int right = num + 1;
            while (numMap.containsKey(left)) {
                numMap.put(left, false);
                templength++;
                left--;
            }
            while (numMap.containsKey(right)) {
                numMap.put(right, false);
                templength++;
                right++;
            }
            if (templength > rangelength) {
                rangelength = templength;
                largestrng[0] = left + 1;
                largestrng[1] = right - 1;
            }
        }
        return largestrng;
    }

    public static void main(String[] args) {
        int[] array = { 1, 4, 2, 5, 3, 0, 6, 7, 10, 22, 56, 11, 9 };
        System.out.println(Arrays.toString(largestRange(array)));
    }
}
