import java.util.*;

public class SubArraySort {
    public static int[] subArraySort(int[] array) {
        int smallestOutOfOrder = Integer.MAX_VALUE;
        int largestOutOfOrder = Integer.MIN_VALUE;
        for (int i = 0; i < array.length; i++) {
            if (breaker(i, array[i], array)) {
                smallestOutOfOrder = Math.min(smallestOutOfOrder, array[i]);
                largestOutOfOrder = Math.max(largestOutOfOrder, array[i]);
            }
        }
        if (smallestOutOfOrder == Integer.MAX_VALUE) {
            return new int[] { -1, -1 };
        }
        int smallIdx = 0;
        while (smallestOutOfOrder >= array[smallIdx]) {
            smallIdx++;
        }
        int largeIdx = array.length - 1;
        while (largestOutOfOrder <= array[largeIdx]) {
            largeIdx--;
        }
        return new int[] { smallIdx, largeIdx };
    }

    public static boolean breaker(int idx, int val, int[] array) {
        if (idx == 0) {
            return val > array[idx + 1];
        }
        if (idx == array.length - 1) {
            return val < array[idx - 1];
        }
        return val > array[idx + 1] || val < array[idx - 1];
    }

    public static void main(String[] args) {
        int[] array = { 1, 2, 3, 4, 8, 9, 38, 13, 14, 15, 19, 23, 35, 11, 45, 78, 88 };
        System.out.println(Arrays.toString(subArraySort(array)));
    }
}
