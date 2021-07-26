public class MaxNonAdjSum {
    public static int maxNonAdjSum(int[] arr) {
        if (arr.length == 0)
            return 0;
        else if (arr.length == 1)
            return arr[0];
        else if (arr.length == 2)
            return Math.max(arr[0], arr[1]);
        int iMinusTwoSum = arr[0];
        int iMinusOneSum = Math.max(arr[0], arr[1]);
        for (int i = 2; i < arr.length; i++) {
            int iSum = Math.max(iMinusOneSum, iMinusTwoSum + arr[i]);
            iMinusTwoSum = iMinusOneSum;
            iMinusOneSum = iSum;
        }
        return iMinusOneSum;
    }

    public static void main(String[] args) {
        int[] array = { 75, 105, 120, 75, 90, 135 };
        System.out.println(maxNonAdjSum(array));
    }
}