import java.util.*;

public class PhoneNumberMnemonics {

    public static HashMap<Character, String[]> NUMBER_MAP = new HashMap<Character, String[]>();
    static {
        NUMBER_MAP.put('1', new String[]{"1"});
        NUMBER_MAP.put('2', new String[]{"a", "b", "c"});
        NUMBER_MAP.put('3', new String[]{"d", "e", "f"});
        NUMBER_MAP.put('4', new String[]{"g", "h", "i"});
        NUMBER_MAP.put('5', new String[]{"j", "k", "l"});
        NUMBER_MAP.put('6', new String[]{"m", "n", "o"});
        NUMBER_MAP.put('7', new String[]{"p", "q", "r","s"});
        NUMBER_MAP.put('8', new String[]{"t", "u", "v"});
        NUMBER_MAP.put('9', new String[]{"w", "x", "y","z"});
        NUMBER_MAP.put('0', new String[]{"0"});
    }

    public static ArrayList<String> getMnemonics(String number) {
        String[] currentMnemonic = new String[number.length()];
        Arrays.fill(currentMnemonic, "0");
        ArrayList<String> mnemonics = new ArrayList<String>();
        getMnemonicsHelper(0, number, currentMnemonic, mnemonics);
        return mnemonics;
    }
    private static void getMnemonicsHelper(int idx, String number,String[] currentMnemonic,ArrayList<String> mnemonics){
        if(idx == number.length()){
            String mnemonic = String.join("", currentMnemonic);
            mnemonics.add(mnemonic);
        }
        else{
            String[] currentNumber = NUMBER_MAP.get(number.charAt(idx));
            for(String s : currentNumber){
                currentMnemonic[idx] = s;
                getMnemonicsHelper(idx+1, number, currentMnemonic, mnemonics);
            }
        }
    }

    public static void main(String[] args) {
        String phoneNumber = "1230";
        System.out.println(getMnemonics(phoneNumber));
    }
}
