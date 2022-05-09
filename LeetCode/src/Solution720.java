import org.junit.Test;

import java.util.HashSet;

/**
 * @author zzz
 * @create 2022-03-17-9:11
 */
public class Solution720 {
    public String longestWord(String[] words) {
        HashSet<String> set = new HashSet<>();
        for(String s : words) set.add(s);
        String res ="";
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            for (int j = 1; j <= word.length(); j++) {
                String s = word.substring(0, j);
                if(!set.contains(s)) break;
                if(j == word.length() && res.length() < word.length()){
                    res = word;
                }
                if(j == word.length()&& res.length() <= word.length()&&(res.compareTo(word)>=0||res.equals(""))) res=word;
            }
        }
        return res;
    }
    @Test
    public void test(){
        System.out.println(longestWord(new String[]{"w", "wo", "wor", "worl", "world"}));
    }
}
