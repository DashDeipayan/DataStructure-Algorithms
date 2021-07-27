import java.util.Arrays;

public class CoinBalancing {
    private static int[] coinArraytemplate(int nums[]) {
        nums[0] = 1;
        Arrays.fill(nums, 1, nums.length, 0);
        return nums;
    }

    public static int coinBalancing(int[] denoms, int value) {
        int coinArray[] = coinArraytemplate(new int[value + 1]);
        if (value == 0)
            return coinArray[value];
        for (int denom : denoms) {
            for (int i = denom; i <= value; i++) {
                coinArray[i] = coinArray[i] + coinArray[i - denom];
            }
        }
        return coinArray[value];
    }

    public static void main(String[] args) {
        System.out.println(coinBalancing(new int[] { 1, 5, 10, 25 }, 10));
        System.out.println(coinBalancing(new int[] { 2, 3, 7 }, 12));
        System.out.println(coinBalancing(new int[] { 2, 4 }, 7));
        System.out.println(coinBalancing(new int[] { 5 }, 9));
        System.out.println(coinBalancing(new int[] { 1, 5 }, 6));
    }
}
