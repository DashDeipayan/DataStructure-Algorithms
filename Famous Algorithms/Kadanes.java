public class Kadanes {
    public static int maxSubArray(int[] nums) {
        int max = nums[0];
        int maxSoFar = nums[0];
        for (int i = 1; i < nums.length; i++) {
            max = Math.max(max + nums[i], 0);
            maxSoFar = Math.max(max, maxSoFar);
        }
        return maxSoFar;
    }

    public static int fixedKadaneMaxSubArray(int[] nums) {
        int max = nums[0];
        int maxSoFar = nums[0];
        for (int i = 1; i < nums.length; i++) {
            max = Math.max(max + nums[i], nums[i]);
            maxSoFar = Math.max(max, maxSoFar);
        }
        return maxSoFar;
    }

    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[] { -2, 1, -3, 4, -1, 2, 1, -5, 4 }));
        System.out.println(maxSubArray(new int[] { -2, -3, -1, -5, -1 }));

        System.out.println(fixedKadaneMaxSubArray(new int[] { -2, 1, -3, 4, -1, 2, 1, -5, 4 }));
        System.out.println(fixedKadaneMaxSubArray(new int[] { -2, -3, -1, -5, -1 }));
    }
}