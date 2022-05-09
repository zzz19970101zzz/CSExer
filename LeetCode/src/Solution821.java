/**
 * @author zzz
 * @create 2022-04-19-10:03
 */
public class Solution821 {
    public int[] shortestToChar(String s, char c) {
        int[] res = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            String s1 = s.substring(0, i);
            String s2 = s.substring(i);
            int in = new StringBuffer(s1).reverse().
                    toString().indexOf(c);
           res[i] = Math.abs(Math.min( in == -1 ? Integer.MAX_VALUE : in
                   ,s2.indexOf(c) == -1 ? Integer.MAX_VALUE: s2.indexOf(c))
                    - i);
        }
        return res;
    }
}
