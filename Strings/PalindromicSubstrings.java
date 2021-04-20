public class PalindromicSubstrings {
    public static int countPalindromicSubstrings(String s) {
        int count = 0;
        int size = s.length();
        for (int i = 0; i < size; i++) {
            count += countSubstrings(s, i, i) + countSubstrings(s, i, i + 1);
        }
        return count;
    }

    private static int countSubstrings(String s, int start, int end) {
        int count = 0;
        int size = s.length();
        while (start >= 0 && end < size && s.charAt(start) == s.charAt(end)) {
            count++;
            start--;
            end++;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(countPalindromicSubstrings("abcba"));
    }
}
