/**
 * @author zzz
 * @create 2022-02-28-9:47
 */
public class Solution1601 {
    //此题用状态压缩是正解
    public int maximumRequests(int n, int[][] requests) {
        int[][] matrix = new int[n][n];
        for (int[] r : requests){
            matrix[r[0]][r[1]] ++;
        }
        return 0;
    }
    public void dfs(){

    }
}
