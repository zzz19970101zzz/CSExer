import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author zzz
 * @create 2022-03-21-11:32
 */
public class SolutionOfferII116 {
    HashSet<Integer> set = new HashSet<>();
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        for (int i = 0; i < n; i++) {
            set.add(i+ 1);
        }
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new ArrayList<>());
        }
        for (int i = 0; i < isConnected.length; i++) {
            for (int j = 0; j < isConnected[i].length; j++) {
                if(i == j) continue;
                if(isConnected[i][j] == 1) list.get(i).add(j);
            }
        }
        int res =1;
        for (int i = 0; i < n; i++) {
            if(!set.contains(i +1)) continue;
            dfs(list,i);
            if(!set.isEmpty()) res++;
        }
        return res;
    }
    public void dfs(List<List<Integer>> list,int i){
      if(!set.contains(i + 1)){
          return;
      }
  set.remove(i + 1);
        for (int j = 0; j < list.get(i).size(); j++) {
            dfs(list,list.get(i).get(j));
        }
    }
    @Test
    public void test(){
        System.out.println(findCircleNum(new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}}));
    }
}
