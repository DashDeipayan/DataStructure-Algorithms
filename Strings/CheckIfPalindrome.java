public class CheckIfPalindrome {
    public static boolean isPalindromeExtraTime(String string) {
        String reversedString = "";
        int size = string.length();
        for (int i = size - 1; i >= 0; i--) {
            reversedString += string.charAt(i); // O(n^2): Time || O(n):space
        }
        return string == reversedString;
    }

    public static boolean isPalindrome(String string) {
        int leftIdx = 0;
        int rightIdx = string.length() - 1;
        while (leftIdx < rightIdx) {
            if (string.charAt(leftIdx) != string.charAt(rightIdx)) {
                return false;
            }
            leftIdx++;
            rightIdx--;
        }
        return true; // O(n):Time || O(1):space
    }

    public static void main(String[] args) {
        String string1 = "abcddcba";
        String string2 = "abcdef";
        System.out.println("String1 is isPalindrome: " + isPalindrome(string1));
        System.out.println("String2 is isPalindrome: " + isPalindromeExtraTime(string2));
    }
}
