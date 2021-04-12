import java.util.*;

public class LongestSubstringWoDups {
    public static String longestSubstringWODups(String str) {
        HashMap<Character, Integer> lastvisit = new HashMap<>();
        int[] longestSub = { 0, 1 };
        int size = str.length();
        int startIdx = 0;
        if (size == 0) {
            return "";
        }
        for (int i = 0; i < size; i++) {
            if (lastvisit.containsKey(str.charAt(i))) {
                startIdx = Math.max(startIdx, lastvisit.get(str.charAt(i)) + 1);
            }
            if (longestSub[1] - longestSub[0] < i + 1 - startIdx) {
                longestSub[0] = startIdx;
                longestSub[1] = i + 1;
            }
            lastvisit.put(str.charAt(i), i);
        }
        return str.substring(longestSub[0], longestSub[1]);
    }

    public static void main(String[] args) {
        String str1 = "abcdefcbe";
        System.out.println(longestSubstringWODups(str1));

        String str2 = "uqwertyu";
        System.out.println(longestSubstringWODups(str2));

        String str3 = "";
        System.out.println(longestSubstringWODups(str3));

        String str4 = "abcdefgh";
        System.out.println(longestSubstringWODups(str4));
    }
}
