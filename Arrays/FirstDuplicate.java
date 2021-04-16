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
}
