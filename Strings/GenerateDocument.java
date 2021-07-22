import java.util.*;

public class GenerateDocument {
    private static Map<Character, Integer> generateMap(String str) {
        Map<Character, Integer> charMap = new HashMap<Character, Integer>();
        for (int i = 0; i < str.length(); i++) {
            if (charMap.containsKey(str.charAt(i))) {
                charMap.put(str.charAt(i), charMap.get(str.charAt(i)) + 1);
            } else {
                charMap.put(str.charAt(i), 1);
            }
        }
        return charMap;
    }

    public static boolean generateDocument(String document, String characters) {
        Map<Character, Integer> charMap = generateMap(characters);
        for (int i = 0; i < document.length(); i++) {
            if (!charMap.containsKey(document.charAt(i))) {
                return false;
            }
            if (charMap.get(document.charAt(i)) == 0) {
                return false;
            } else {
                charMap.put(document.charAt(i), charMap.get(document.charAt(i)) - 1);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String characters = "helloworld0";
        String document = "hello w0rld";
        System.out.println(generateDocument(document, characters));
    }
}
