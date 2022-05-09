import java.util.ArrayList;
import java.util.List;

/**
 * @author zzz
 * @create 2022-04-27-10:26
 */
public class Solution417 {
    int[][] h;
    boolean[][] pacific;
    boolean[][] atlantic;
    int[][] dir = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        h = heights;
        int m = h.length;
        int n = h[0].length;
        pacific = new boolean[m][n];
        atlantic = new boolean[m][n];
        for (int i = 0; i < n; i++) {
            dfs(0,i,pacific,0);
        }
        for (int i = 0; i < m; i++) {
            dfs(i,0,pacific,0);
        }
        for (int i = 0; i < m; i++) {
            dfs(i,n - 1,atlantic,0);
        }
        for (int i = 0; i < n; i++) {
            dfs(m - 1,i,atlantic,0);
        }
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < h.length; i++) {
            for (int j = 0; j < n; j++) {
                if(pacific[i][j] && atlantic[i][j]){
                    List<Integer> l = new ArrayList<>();
                    l.add(i);l.add(j);
                    res.add(l);
                }
            }
        }
        return res;
    }
    public void dfs(int i,int j,boolean[][] ocean,int old){
        if(i < 0 || i >= h.length || j < 0 || j >= h[0].length
                || ocean[i][j])
            return;
        if(h[i][j] < old) return;
        ocean[i][j] = true;
        for(int[] in : dir){
            dfs(i + in[0],j + in[1],ocean,h[i][j]);
        }
    }
}
