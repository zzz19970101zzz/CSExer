import org.junit.Test;

/**
 * @author zzz
 * @create 2022-04-29-9:38
 */
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;


    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }

    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }

    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
}
public class Solution427 {
    public Node construct(int[][] grid) {

        return dfs(grid,grid.length - 1,0,0,grid.length -1);
    }
    public Node dfs(int[][] grid,int b1,int b2, int t1,int t2  ){
        if(check(grid, b1, b2,t1,t2)){
            Node node = new Node(grid[b1][b2] == 1 ? true:false,true);
            return node;
        }
        Node node = new Node(false, false);
        int t = (b1 - t1+1) >>1;
        int b = (t2 - b2+1) >>1;
        node.bottomLeft = dfs(grid,b1,b2,t1 + t,b2  + b - 1);
        node.bottomRight = dfs(grid,b1,b2 + b,t1 + t,t2);
        node.topLeft = dfs(grid,t1 + t - 1,b2,t1,b2 + b - 1);
        node.topRight = dfs(grid,t1 + t - 1,b2  + b,t1,t2 );
        return node;
    }
    public boolean check(int[][] grid,int b1,int b2, int t1,int t2  ){
        int a = grid[b1][b2];
        for (int i = b2; i <= t2; i++) {
            for (int j = t1; j <= b1; j++) {
                if(grid[j][i] != a){
                    return false;
                }
            }
        }
        return true;
    }
    @Test
    public void test(){
        construct(new int[][]{{1,1,1,1,0,0,0,0},{1,1,1,1,0,0,0,0},
                {1,1,1,1,1,1,1,1},
                {1,1,1,1,1,1,1,1}
                ,{1,1,1,1,0,0,0,0},
                {1,1,1,1,0,0,0,0},{1,1,1,1,0,0,0,0},
                {1,1,1,1,0,0,0,0}});
    }
}
