public class SingleCycleCheck {
    private static int nextIndex(int[] array, int currentIdx) {
        int nextIdx = (currentIdx + array[currentIdx]) % array.length;
        return nextIdx >= 0 ? nextIdx : (nextIdx + array.length);
    }

    public static boolean singleCycleCheck(int[] array) {
        int count = 0, i = 0;
        int size = array.length;
        while (count < size) {
            if (count > 0 && i == 0) {
                return false;
            }
            count++;
            i = nextIndex(array, i);
        }
        return i == 0;
    }

    public static void main(String[] args) {
        int[] array = { 2, 3, 1, -4, -4, 2 };
        System.out.println(singleCycleCheck(array));
    }
}
