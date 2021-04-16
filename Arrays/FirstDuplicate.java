import java.util.*;

public class FirstDuplicate {
    public static int firstDuplicate(int[] arr) {
        HashSet<Integer> dupliSet = new HashSet<Integer>();
        for (int value : arr) {
            if (!dupliSet.contains(value)) {
                Integer v = value;
                dupliSet.add(v);
            } else {
                return value;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] array = { 1, 2, 3, 4, 5, 6, 4, 5, 6, 7, 8 };
        System.out.println(firstDuplicate(array));
    }
}
