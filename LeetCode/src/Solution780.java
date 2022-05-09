/**
 * @author zzz
 * @create 2022-04-09-9:39
 */
public class Solution780 {
    public boolean reachingPoints(int sx, int sy, int tx, int ty) {
        return dfs(sx,sy,tx,ty);
    }
    public boolean dfs(int sx,int sy,int tx,int ty){
        if(tx < sx || ty < sy) return false;
        if(ty == sy  ) return (tx-sx) % sy == 0;
        if(tx == sx  ) return (ty-sy) % sx == 0;
//        return tx > ty ?dfs(sx,sy,tx%ty,ty) :  dfs(sx,sy,tx,ty%tx);
        return dfs(sy,sx,ty%tx,tx);

    }

}
