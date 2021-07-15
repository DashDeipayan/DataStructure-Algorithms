
import java.util.*;

public class SuffixTrie {
    private class TrieNode {
        Map<Character, TrieNode> children = new HashMap<Character, TrieNode>();
    }

    private Character end = '*';
    private TrieNode root = new TrieNode();

    SuffixTrie(String s) {
        for (int i = 0; i < s.length(); i++) {
            insertSubstringFrom(i, s);
        }
    }

    private void insertSubstringFrom(int i, String s) {
        TrieNode curr = root;
        for (int j = i; j < s.length(); j++) {
            Character c = s.charAt(j);
            if (!curr.children.containsKey(c)) {
                curr.children.put(c, new TrieNode());
            }
            curr = curr.children.get(c);
        }
        curr.children.put(end, null);
    }

    public boolean containSuffix(String s) {
        TrieNode curr = root;
        for (int i = 0; i < s.length(); i++) {
            if (!curr.children.containsKey(s.charAt(i))) {
                return false;
            }
            curr = curr.children.get(s.charAt(i));
        }
        return curr.children.containsKey(end);
    }

    public static void main(String[] args) {
        SuffixTrie trie = new SuffixTrie("abacbdad");

        System.out.println(trie.containSuffix("cbdad"));
        System.out.println(trie.containSuffix("dad"));
        System.out.println(trie.containSuffix("aba"));
    }
}