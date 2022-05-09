import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author zzz
 * @create 2022-04-11-21:39
 */
public class SolutionOffer38 {
    Set<String> set = new HashSet<>();
    public String[] permutation(String s) {
        dfs(new StringBuffer(),new boolean[s.length()],s);
        String[] res = new String[set.size()];
        int i = 0;
        for (String s1 : set) {
            res[i] = s1;
            i++;
        }
        return res;
    }
    public void dfs(StringBuffer sb,boolean[] isvisited,String s){
        if(sb.length() == s.length()){
            set.add(sb.toString());
            return;
        }
        for (int i = 0; i < s.length(); i++) {
            if(isvisited[i]) continue;
            sb.append(s.charAt(i));
            isvisited[i] = true;
            dfs(sb,isvisited,s);
            sb.deleteCharAt(sb.length() - 1);
            isvisited[i] = false;
        }
    }
    @Test
    public void test(){
        System.out.println(permutation("112"));
    }
}
