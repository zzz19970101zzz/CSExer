import org.junit.Test;

/**
 * @author zzz
 * @create 2022-03-08-10:15
 */
public class Solution2055 {
    //tle
    public int[] platesBetweenCandles(String s, int[][] queries) {
        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int i1 = find(s.substring(queries[i][0], queries[i][1] + 1));
            res[i] = i1;
        }
        System.out.println();
        return res;
    }
    public int find(String s){
        int l = 0;
        int r = s.length() - 1;
        while (l < s.length() && s.charAt(l) != '|'){
            l++;
        }
        while (r >= 0 && s.charAt(l) != '|'){
            r--;
        }
        int res = 0;
        for (int i = l; i < r; i++) {
            if(s.charAt(i) == '*') res ++;
        }
        System.out.println();
        return res;
    }
    //
    public int[] platesBetweenCandles1(String s, int[][] queries) {
        int[] dp = new int[s.length()];
        int index = 0;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '|'){
                if(index == i - 1) dp[i] = dp[index];
                dp[i] = index;
                index = i;
            }
        }
        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int l = queries[i][0];
            int r = queries[i][1];
            int sum = 0;
            while (r > l){
                if(s.charAt(r) == '|') break;
                r--;
            }
            while (r > l){
                if(s.charAt(l) == '|') break;
                l++;
            }
            while (r > l){
                if(dp[r] < l) break;
               sum += r - dp[r] - 1;
               r= dp[r];
            }
            res[i] = sum;
        }
        System.out.println();
        return res;
    }

        @Test
    public void test(){
//        platesBetweenCandles1(
//               "**|**|***|",new int[][]{{2,5},{5,9}});
//        platesBetweenCandles1("**|*******************|**********************************************|************|*********|*****|*********************************************************************************************|***"
//        ,new int[][]{{0,180}});
        platesBetweenCandles1("***|**|*****|**||**|*",new int[][]{{1,17}});
    }
}
