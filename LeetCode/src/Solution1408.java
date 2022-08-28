import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @author zzz
 * @create 2022-08-06-9:25
 */
public class Solution1408 {
    public List<String> stringMatching(String[] words) {
        HashSet<String> set = new HashSet<>();
        for(String s : words){
            set.add(s);
        }
        HashSet<String> set1 = new HashSet<>();
        List<String> res = new ArrayList<>();
        for(String s : words){
            for (int i = 1; i < s.length(); i++) {
                String sb1 = s.substring(i, s.length());
                if(set.contains(sb1))
                    set1.add(sb1);
            }
            for (int i = s.length() - 1; i >= 0; i--) {
                String sb1 = s.substring(0,i);
                if(set.contains(sb1))
                    set1.add(sb1);
            }
            for (int i = 1; i < s.length(); i++) {
                for (int j = s.length() - 1; j >= i; j--) {
                    if(set.contains(s.substring(i,j)))
                        set1.add(s.substring(i,j));
                }
            }
        }
        res = new ArrayList<>(set1);
        return res;
    }
}
