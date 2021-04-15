public class MonotonicArray {
    public static boolean monotonicArray(int[] array) {
        int direction = 0;
        int i = 0;
        int size = array.length;
        if (size <= 2)
            return true;
        while (direction == 0 && i < size - 1) {
            if (array[i + 1] - array[i] > 0) {
                direction = 1;
            } else if (array[i + 1] - array[i] < 0) {
                direction = -1;
            } else {
                i++;
            }
        }
        boolean isDirection = true;
        i = 0;
        while (i < size - 1 && isDirection) {
            if (direction == 1 && array[i + 1] - array[i] < 0) {
                direction = -1;
                isDirection = false;
            } else if (direction == -1 && array[i + 1] - array[i] > 0) {
                direction = 1;
                isDirection = false;
            }
            i++;
        }
        return isDirection;
    }

    public static void main(String[] args) {
        int[] array = { -1, -1, -1, -1, -1, -1, -1, -1 };
        System.out.println(monotonicArray(array));
    }
}
