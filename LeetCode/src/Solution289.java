import org.junit.Test;

/**
 * @author zzz
 * @create 2022-02-28-14:27
 */
public class Solution289 {
    public void gameOfLife(int[][] board) {

        int[][] copy = new int[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                copy[i][j] = board[i][j];
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                int alive = 0;
                if(j - 1 >= 0 && copy[i][j - 1] == 1) alive++;
                if(i - 1 >= 0 && copy[i - 1][j] == 1) alive++;
                if(j + 1 < board[i].length && copy[i][j + 1] == 1) alive++;
                if(i + 1 < board.length  && copy[i + 1][j] == 1) alive++;

                if(j - 1 >= 0 && i - 1 >=0 && copy[i - 1][j - 1] == 1) alive++;
                if(i - 1 >= 0 && j +1 < board[i].length && copy[i - 1][j + 1] == 1) alive++;
                if(j - 1 >=0 && i + 1 < board.length && copy[i + 1][j - 1] == 1) alive++;
                if(i + 1 < board.length && j + 1 < board[i].length && copy[i + 1][j + 1] == 1) alive++;

                if(board[i][j] == 1){
                    if(alive < 2 || alive > 3) board[i][j] = 0;
                }else {
                  if(alive == 3) board[i][j] = 1;
                }
            }
        }

    }
    @Test
    public void test(){
        gameOfLife(new int[][]{{0,0,0,0},{0,1,1,0},{0,1,1,0},{0,0,0,0}});
    }
}
