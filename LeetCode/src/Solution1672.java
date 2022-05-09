/**
 * @author zzz
 * @create 2022-04-14-9:11
 */
public class Solution1672 {
    public int maximumWealth(int[][] accounts) {

        int max = 0;
        for (int i = 0; i < accounts.length; i++) {
            int sum = 0;
            for (int j = 0; j < accounts[i].length; j++) {
                sum += accounts[i][j];
            }
            max = Math.max(max,sum);
        }
        return max;
    }
}
