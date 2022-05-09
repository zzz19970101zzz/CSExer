/**
 * @author zzz
 * @create 2022-04-12-9:42
 */
public class Solution806 {
    public int[] numberOfLines(int[] widths, String s) {
        int[] res = new int[2];
        int m = 1;
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            sum += widths[c - 'a'];
            if(sum > 100){
                m++;
                sum = widths[c - 'a'];
            }
        }
        res[0] = m;
        res[1] = sum;
        return res;
    }
}
