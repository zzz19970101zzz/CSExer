import java.util.Arrays;

/**
 * @author zzz
 * @create 2022-03-08-14:15
 */
public class Solution242 {
    public boolean isAnagram(String s, String t) {

        if(s.length() != t.length()) return false;
        char[] c1 = s.toCharArray();
        char[] c2 = t.toCharArray();
        Arrays.sort(c1);
        Arrays.sort(c2);
        for (int i = 0; i < c1.length; i++) {
            if(c1[i] != c2[i]) return false;
        }
        return true;
    }
}
