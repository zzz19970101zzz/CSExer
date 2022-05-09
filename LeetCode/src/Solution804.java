
import java.util.HashSet;

/**
 * @author zzz
 * @create 2022-04-10-9:33
 */
public class Solution804 {
    String[] arr = new String[]{".-","-...","-.-.","-..",".","..-."
            ,"--.","....","..",".---","-.-",".-..",
            "--","-.","---",".--.","--.-",
            ".-.","...","-","..-",
            "...-",".--","-..-","-.--","--.."};

    public int uniqueMorseRepresentations(String[] words) {

        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            String s ="";
            for(char c : word.toCharArray()){
                s +=arr[c-'a'];
            }
            set.add(s);
        }
        return set.size();
    }
}
