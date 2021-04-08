public class LongestPalindromeSubString{
    public static void printSubString(String str, int left, int right){
        System.out.println(str.substring(left, right));
    } 

    public static void longestPalindromeSubString(String string){
        int from = 0, to=1;
        int left,right;
        int size = string.length();
        for (int i=1;i<size;i++){
            left = i-1;
            right = i;
            while(left>=0 && right<size && string.charAt(left)==string.charAt(right)){
                if(right-left+1>to){
                    from = left;
                    to = right-left+1;
                }
                left--;
                right++;
            }
            left = i-1;
            right= i+1;
            while(left>=0 && right<size && string.charAt(left)==string.charAt(right)){
                if(right-left+1>to){
                    from = left;
                    to = right-left+1;
                }
                left--;
                right++;
            }
        }
        printSubString(string, from, from+to);
    }

    public static void main(String[] args){
        String str = "abcxyyzzyyxabc";
        longestPalindromeSubString(str);
    }    
}