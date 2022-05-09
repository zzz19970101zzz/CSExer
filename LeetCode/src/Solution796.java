/**
 * @author zzz
 * @create 2022-04-07-9:21
 */
public class Solution796 {
    public boolean rotateString(String s, String goal) {
        int len = s.length();
        for (int i = 0; i < len; i++) {
            String s1 =  s.substring(i,len) + s.substring(0,i) ;
            if(s1.equals(goal))return true;
        }
        return false;
    }
}
