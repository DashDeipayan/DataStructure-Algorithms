import java.util.*;

public class MinCoinsForChange {
    private static int[] coinArraytemplate(int[] nums) {
        Arrays.fill(nums, Integer.MAX_VALUE);
        nums[0] = 0;
        return nums;
    }

    public static int minCoins(int[] denoms, int target) {
        int[] nums = coinArraytemplate(new int[target + 1]);
        int temp = 0;
        for (int denom : denoms) {
            for (int j = 0; j <= target; j++) {
                if (denom <= j) {
                    if (nums[j - denom] == Integer.MAX_VALUE) {
                        temp = nums[j - denom];
                    } else {
                        temp = nums[j - denom] + 1;
                    }
                    nums[j] = Math.min(nums[j], temp);
                }
            }
        }
        return nums[target] != Integer.MAX_VALUE ? nums[target] : -1;
    }

    public static void main(String[] args) {
        System.out.println(minCoins(new int[] { 1, 5, 10, 25 }, 10));
        System.out.println(minCoins(new int[] { 2, 3, 7 }, 12));
        System.out.println(minCoins(new int[] { 2, 4 }, 7));
        System.out.println(minCoins(new int[] { 5 }, 9));
        System.out.println(minCoins(new int[] { 1, 5 }, 6));
    }
}
