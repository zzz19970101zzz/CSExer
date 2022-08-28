/**
 * @author zzz
 * @create 2022-05-10-9:37
 */
public class Solution1728 {
    char[][] g;
    int c,m ;
    public boolean canMouseWin(String[] grid, int catJump, int mouseJump) {
        c = catJump;
        m = mouseJump;

        return true;
    }
    public boolean dfs(int i1,int j1,int i2,int j2){
        if(i1 < 0 || j1 < 0 || i1 > g.length || j1 > g.length)
            return true;
        if(i2 < 0 || j2 < 0 || i2 > g.length || j2 > g.length)
            return true;
        if(g[i1][j1] == '#' || g[i2][j2] == '#')
            return true;

        return false;
    }
}
