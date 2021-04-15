import java.util.Arrays;

public class ThreeNumberSum {
    public static void threeNumberSum(int[] array, int target) {
        Arrays.sort(array);
        System.out.println(Arrays.toString(array));
        int size = array.length;
        int[] tempArray = new int[3];
        for (int i = 0; i < size; i++) {
            int currentNum = array[i];
            int left = i + 1;
            int right = size - 1;
            int flag = 0;
            while (left < right) {
                if (currentNum + array[left] + array[right] == target) {
                    tempArray[0] = currentNum;
                    tempArray[1] = array[left];
                    tempArray[2] = array[right];
                    System.out.println(Arrays.toString(tempArray));
                    flag = 1;
                } else if (currentNum + array[left] + array[right] < target && flag == 0) {
                    ++left;
                } else if (currentNum + array[left] + array[right] > target && flag == 0) {
                    --right;
                }
                if (flag == 1) {
                    ++left;
                    --right;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr1 = { 12, 3, 1, 2, -6, 5, 0, -8, -1, 6 };
        int target = 0;
        threeNumberSum(arr1, target);
    }
}
