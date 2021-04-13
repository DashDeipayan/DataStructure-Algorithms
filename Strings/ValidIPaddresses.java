import java.util.*;

public class ValidIPaddresses {
    private static boolean isValid(String string) {
        int stringToInt = Integer.parseInt(string);
        if (stringToInt > 255 || string.length() == 0 || (string.charAt(0) == '0' && string.length() > 1)
                || string.length() > 3) {
            return false;
        }
        return true;
    }

    public static ArrayList<String> validIPadresses(String string) {
        ArrayList<String> ipAdresses = new ArrayList<String>();
        int size = string.length();
        if (size > 12) {
            ipAdresses.add("");
            return ipAdresses;
        }
        for (int i = 1; i < 4 && i < size - 2; i++) {
            for (int j = i + 1; j < i + 4 && j < size - 1; j++) {
                for (int k = j + 1; k < j + 4 && k < size; k++) {
                    String s1 = string.substring(0, i), s2 = string.substring(i, j), s3 = string.substring(j, k),
                            s4 = string.substring(k);
                    if (isValid(s1) && isValid(s2) && isValid(s3) && isValid(s4)) {
                        ipAdresses.add(s1 + "." + s2 + "." + s3 + "." + s4);
                    }
                }
            }
        }
        return ipAdresses;
    }

    public static void main(String[] args) {
        String str1 = "0279245587303";
        System.out.println(validIPadresses(str1).toString());
    }
}
