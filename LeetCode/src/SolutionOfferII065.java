import org.junit.Test;

import javax.sound.sampled.ReverbType;
import java.util.Arrays;
import java.util.Comparator;

/**
 * @author zzz
 * @create 2022-03-19-14:28
 */
public class SolutionOfferII065 {
    class Trie{
        class TrieNode{
            boolean isEnd ;
            TrieNode[] children;
            public TrieNode(){
                children = new TrieNode[26];
            }
        }
        TrieNode root;
        public Trie(){
            root = new TrieNode();
        }
        public void insert(String s){
            TrieNode t = root;
            for(char c:s.toCharArray()){
                int i = c - 'a';
                if(t.children[i] == null) t.children[i] = new TrieNode();
                t= t.children[i];
            }
            t.isEnd = true;
        }
        public boolean startsWith(String s ){
            TrieNode t = root;
            for(char c:s.toCharArray()){
                int i = c - 'a';
                if(t.children[i] == null) return false;
                t= t.children[i];
            }
            return true;
        }
        public boolean isHave(String s){
            TrieNode t = root;
            for(char c:s.toCharArray()){
                int i = c - 'a';
                if(t.children[i] == null) return false;
                t= t.children[i];
            }
            return t.isEnd;
        }
    }
    public int minimumLengthEncoding(String[] words) {
        Trie trie = new Trie();
        int res = 0;
        for (int i = 0; i < words.length; i++) {
            String resverse = resverse(words[i]);
            words[i] = resverse;
        }
        Arrays.sort(words, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.length() - o1.length();
            }
        });
        for(String s : words){
            if(trie.startsWith(s)) continue;
            trie.insert(s);
            res+=s.length();
            res++;
        }
        return res ;
    }
    public String resverse(String s){
        String r = "";
        for (int i = s.length() - 1; i >= 0; i--) {
            r+=s.charAt(i);
        }
        return r;
    }
    @Test
    public void  test(){
        System.out.println(minimumLengthEncoding(new String[]{"time", "me", "bell"}));
    }
}
