import java.util.Arrays;

public class ProductArray {
    public static int product(int[] array) {
        int product = 1, flag = 0;
        for (int value : array) {
            if (value == 0 && flag == 0) {
                flag = 1;
                continue;
            } else if (value == 0 && flag == 1)
                return 0;
            product = product * value;
        }
        return product;
    }

    public static int[] productArray(int[] array) {
        int product = product(array), i = 0;
        boolean hasZero = false;
        for (int value : array) {
            if (value == 0) {
                hasZero = true;
                break;
            }
        }
        for (int value : array) {
            if (hasZero) {
                if (value == 0)
                    array[i++] = product;
                else
                    array[i++] = 0;
            } else
                array[i++] = product / value;
        }
        return array;
    }

    public static void main(String[] args) {
        int[] arr1 = { 5, 1, 4, 0 };
        System.out.println(Arrays.toString(productArray(arr1)));
    }
}
