
//Time Complexity: O(n)  Space Complexity: O(n)--------For Priority Queue(Heap)
import java.util.*;

public class ThreeLargestNums {
    private static PriorityQueue<Integer> makePriorityQueue(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int num : nums) {
            pq.add(num);
        }
        return pq;
    }

    public static int[] threeLargestNums(int[] nums) {
        int threeLargestNums[] = new int[3];
        PriorityQueue<Integer> pq = makePriorityQueue(nums);
        for (int i = 2; i >= 0; i--) {
            threeLargestNums[i] = pq.poll();
        }
        return threeLargestNums;
    }

    public static void main(String[] args) {
        int[] array = { 141, 1, 17, -7, -17, -27, 18, 541, 8, 7, 7 };
        System.out.println(Arrays.toString(threeLargestNums(array)));
    }
}