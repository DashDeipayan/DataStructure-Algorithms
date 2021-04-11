import java.util.*;

public class GroupAnagrams {
    private static String sortedString(String string) {
        char[] tempArray = string.toCharArray();
        Arrays.sort(tempArray);
        return new String(tempArray);
    }

    private static String[] groupAnagrams(String[] words) {
        HashMap<String, ArrayList<String>> sortedWordsMap = new HashMap<String, ArrayList<String>>();
        for (String word : words) {
            String keyWord = sortedString(word);
            if (sortedWordsMap.containsKey(keyWord) == false) {
                sortedWordsMap.put(keyWord, new ArrayList<String>());
            }
            sortedWordsMap.get(keyWord).add(word);
        }
        int size = sortedWordsMap.size();
        return groupAnagramsMapValues(sortedWordsMap, size);
    }

    public static String[] groupAnagramsMapValues(HashMap<String, ArrayList<String>> map, int size) {
        String[] groupAnagrams = new String[size];
        int i = 0;
        for (String keyName : map.keySet()) {
            String keyString = keyName.toString();
            String value = map.get(keyString).toString();
            groupAnagrams[i] = value;
            i++;
        }
        return groupAnagrams;
    }

    public static void main(String[] args) {
        String[] set1 = { "tor", "fo", "rofl", "of", "forl", "ort", "flor" };
        System.out.println(Arrays.toString(groupAnagrams(set1)));

        String[] set2 = { "tor", "fo" };
        System.out.println(Arrays.toString(groupAnagrams(set2)));

        String[] set3 = { "blah" };
        System.out.println(Arrays.toString(groupAnagrams(set3)));

        String[] set4 = { "" };
        System.out.println(Arrays.toString(groupAnagrams(set4)));

    }
}
