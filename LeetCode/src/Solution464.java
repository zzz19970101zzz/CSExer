import org.junit.Test;

/**
 * @author zzz
 * @create 2022-05-22-9:27
 */
public class Solution464 {
    int total;
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        total = desiredTotal;
        boolean win = false;
        for (int i = 0; i < maxChoosableInteger; i++) {
            boolean[] isVisited = new boolean[maxChoosableInteger];
            win = win || dfs(isVisited,i,0,true);
            if(win) return win;
        }
        return win;
    }
    public boolean dfs(boolean[] isVisited,int i,int sum,boolean isFirst){
        isVisited[i] = true;
        sum += i + 1;
        if(sum >= total && isFirst) {
            return true;
        }
        if(sum >= total && !isFirst) {
            return false;
        }
        boolean result = true;
        for (int k = 0; k < isVisited.length; k++) {
            if(isVisited[k]) continue;
            result = result && dfs(isVisited,k,sum,!isFirst);
            if(!result) break;
        }
        return result;
    }
    @Test
    public void test(){
        System.out.println(canIWin(10, 11));
//        System.out.println(canIWin(10, 0));
//        System.out.println(canIWin(10, 1));
//        System.out.println(canIWin(10, 40));
//        System.out.println(canIWin(4, 6));

    }
}

