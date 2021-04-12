import java.util.*;

public class FirstNonRepeatingChar {
    public static int firstNonRepeatingChar(String string) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int size = string.length();
        for (int i = 0; i < size; i++) {
            if (!map.containsKey(string.charAt(i))) {
                map.put(string.charAt(i), 1);
            } else {
                map.put(string.charAt(i), map.get(string.charAt(i)) + 1);
            }
        }
        for (int i = 0; i < size; i++) {
            if (map.get(string.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String str1 = "abcdabd";
        System.out.println(firstNonRepeatingChar(str1));

        String str2 = "aaaaaa";
        System.out.println(firstNonRepeatingChar(str2));

        String str3 = "abcd";
        System.out.println(firstNonRepeatingChar(str3));

        String str4 = "";
        System.out.println(firstNonRepeatingChar(str4));
    }
}
