import org.junit.Test;

/**
 * @author zzz
 * @create 2022-03-20-21:34
 */
public class SolutionOfferII105 {
    int res = 0;
    int area = 0;
    public int maxAreaOfIsland(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if(grid[i][j] == 0){
                    continue;
                }
                dfs(grid,i,j);
                res = Math.max(res,area);
                area=0;
            }
        }
        return res;
    }
    public void dfs(int[][]grid ,int i,int j){
        if(i >= grid.length || i <0 || j >= grid[i].length || j<0
            || grid[i][j] == 0){
            return;
        }
        grid[i][j] = 0;
        area++;
        dfs(grid,i + 1,j);
        dfs(grid,i ,j + 1);
        dfs(grid,i - 1,j);
        dfs(grid,i,j - 1);
    }
    @Test
    public void test(){
        System.out.println(maxAreaOfIsland(new int[][] {
                {0,0,1,0,0,0,0,1,0,0,0,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,1,1,0,1,0,0,0,0,0,0,0,0},
                {0,1,0,0,1,1,0,0,1,0,1,0,0},
                {0,1,0,0,1,1,0,0,1,1,1,0,0},
                {0,0,0,0,0,0,0,0,0,0,1,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,0,0,0,0,0,0,1,1,0,0,0,0}}));
    }
}
