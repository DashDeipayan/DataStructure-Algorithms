public class RunLengthEncoding {
    private static String countConcat(int count, char c) {
        return String.format("%d%c", count, c);
    }

    public static String runLengthEncode(String s) {
        String encodedString = "";
        char temp = s.charAt(0);
        int count = 1;
        for (int i = 1; i < s.length(); i++) {
            if (count == 9 || s.charAt(i) != temp) {
                encodedString += countConcat(count, temp);
                temp = s.charAt(i);
                count = 1;
            } else {
                count++;
            }
        }
        return encodedString + countConcat(count, temp);
    }

    public static void main(String[] args) {
        String s = "AAAAAAAAAAAAAAAAAAAABBCCC";
        System.out.println(runLengthEncode(s));
    }
}
