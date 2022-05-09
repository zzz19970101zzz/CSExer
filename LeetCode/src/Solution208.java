import org.junit.experimental.theories.Theories;

/**
 * @author zzz
 * @create 2022-03-18-13:02
 */
public class Solution208 {

}

class Trie {
    class TrieNode{
        boolean isEnd;
        TrieNode[] children=new TrieNode[26];
    }
    TrieNode root;
    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode t = root;
        for(char c : word.toCharArray()){
            int i = c -'a';
            if(t.children[i] == null){
                t.children[i] = new TrieNode();
            }
            t = t.children[i];
        }
        t.isEnd = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode t = root;
        for(char c: word.toCharArray()){
            int i = c -'a';
            if(t.children[i] == null) return false;
            t = t.children[i];
        }
        return t.isEnd;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode t = root;
        for(char c: prefix.toCharArray()){
            int i = c -'a';
            if(t.children[i] == null) return false;
            t = t.children[i];
        }
        return true;
    }
}