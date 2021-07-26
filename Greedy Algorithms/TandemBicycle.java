import java.util.*;

public class TandemBicycle {
    private static int fastestGo(int arrOne[], int arrTwo[]) {
        int sum = 0;
        for (int i = 0, j = arrTwo.length - 1; i < arrOne.length; i++, j--) {
            sum += Math.max(arrOne[i], arrTwo[j]);
        }
        return sum;
    }

    private static int slowestGo(int arrOne[], int arrTwo[]) {
        int sum = 0;
        for (int i = 0; i < arrOne.length; i++) {
            sum += Math.max(arrOne[i], arrTwo[i]);
        }
        return sum;
    }

    public static int tandemBicycle(int[] redShirt, int[] blueShirt, boolean fastest) {
        Arrays.sort(redShirt);
        Arrays.sort(blueShirt);
        if (fastest) {
            return fastestGo(redShirt, blueShirt);
        } else {
            return slowestGo(redShirt, blueShirt);
        }
    }

    public static void main(String[] args) {
        int redShirt[] = { 5, 5, 3, 9, 2 };
        int blueShirt[] = { 3, 6, 7, 2, 1 };
        boolean fastest = true;
        System.out.println(tandemBicycle(redShirt, blueShirt, fastest));
    }
}
