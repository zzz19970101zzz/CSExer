import org.junit.Test;

/**
 * @author zzz
 * @create 2022-08-14-9:07
 */
public class Solution1422 {
    public int maxScore(String s) {
        int len = s.length();
        int[] zero = new int[len];
        zero[0] = s.charAt(0) == '0' ? 1 : 0;
        int[] one = new int[len];
        one[len -1] = s.charAt(s.length() - 1) == '1' ? 1 : 0;

        for (int i = 1;i < s.length(); i++) {
            if( s.charAt(i) == '0')
                zero[i] = zero[i - 1] + 1;
            else
                zero[i] = zero[i - 1];
        }
        for (int i = s.length() - 2;i >= 0; i--) {
            if( s.charAt(i) == '1')
                one[i] = one[i + 1] + 1;
            else
                one[i] = one[i + 1];
        }
        int res = 0;
        for (int i = 0; i < len - 1; i++) {
            int p = zero[i] + one[i + 1];
            res = Math.max(res,p);
        }
        return res > one[len -1] ? res : one[len - 1];
    }
    @Test
    public void test(){
        System.out.println(maxScore("011101"));
    }
}
