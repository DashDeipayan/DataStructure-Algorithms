import java.util.*;

public class MergeOverlappingIntervals {
    public static int[][] mergeOverlaps(int[][] array) {
        Arrays.sort(array, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> result = new ArrayList<int[]>();
        int[] interval = array[0];
        result.add(interval);
        for (int[] value : array) {
            int currentEnd = interval[1];
            int nextStart = value[0];
            int nextEnd = value[1];
            if (currentEnd >= nextStart) {
                interval[1] = Math.max(currentEnd, nextEnd);
            } else {
                interval = value;
                result.add(interval);
            }
        }
        return result.toArray(new int[result.size()][]);
    }

    public static void main(String[] args) {
        int[][] array = { { 1, 2 }, { 4, 7 }, { 3, 5 }, { 9, 10 }, { 6, 8 } };
        System.out.println(Arrays.deepToString(mergeOverlaps(array)));
    }
}
