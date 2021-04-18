import java.util.*;

public class ReverseWordsInStrings {
    public static String[] reverseWords(String[] array) {
        String temp = new String();
        int size = array.length;
        for (int i = 0; i < size / 2; i++) {
            temp = array[i];
            array[i] = array[size - i - 1];
            array[size - i - 1] = temp;
        }
        return array;
    }

    public static String reverseWordsInStrings(String string) {
        String[] newStrings = string.split(" ", 0);
        newStrings = reverseWords(newStrings);
        String result = "";
        for (String string2 : newStrings) {
            if (!(string2 == null))
                result = result + string2 + " ";
        }
        return result.substring(0, result.length() - 1);
    }

    public static String reverseWordsInStringsWithStack(String string) {
        int size = string.length();
        if (size == 0)
            return string;
        Stack<String> stack = new Stack<String>();
        String result = "";
        for (int i = 0; i < size; i++) {
            String word = "";
            if (string.charAt(i) == ' ')
                continue;
            while (i < size && string.charAt(i) != ' ') {
                word += string.charAt(i);
                i++;
            }
            stack.push(word);
        }
        while (!stack.isEmpty()) {
            result += stack.peek();
            stack.pop();
            if (!stack.isEmpty())
                result += " ";
        }
        return result;
    }

    public static void main(String[] args) {
        String s = "  Hello World  ";
        System.out.println(reverseWordsInStrings(s));
        System.out.println(reverseWordsInStrings(s) + "<-with stack");
    }
}
