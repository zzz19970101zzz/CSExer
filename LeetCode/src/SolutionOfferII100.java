import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author zzz
 * @create 2022-03-17-10:24
 */
public class SolutionOfferII100 {
    int res = Integer.MAX_VALUE;
    public int minimumTotal(List<List<Integer>> triangle) {

        dfs(triangle,0,0,0);
        return res;
    }
    public void dfs(List<List<Integer>> triangle,int i,int p,int sum){
        if(i == triangle.size()){
            res = Math.min(res,sum);
            return;
        }
        if(p >= triangle.get(i).size()) return;
        sum += triangle.get(i).get(p);
        if(i< triangle.size() - 1 && triangle.get(i + 1).get(p) < triangle.get(i +1).get(p +1))
        dfs(triangle,i  +1,p,sum);
        else
        dfs(triangle,i + 1,p +1,sum);
        sum -= triangle.get(i).get(p);
    }
    public int minimumTotal1(List<List<Integer>> triangle) {
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(0);
        int ceng = 0;
        while (!queue.isEmpty()){
            int size = queue.size();
            while (size-->0){
                Integer poll = queue.poll();

            }
            ceng++;
        }
        return res;
    }
    @Test
    public void test(){
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        list1.add(2);
        List<Integer> list2 = new ArrayList<>();
        list2.add(4);
        list2.add(3);

        List<Integer> list3 = new ArrayList<>();
        list3.add(6);
        list3.add(5);
        list3.add(7);
        list.add(list1);list.add(list2);list.add(list3);
        System.out.println(minimumTotal2(list));
    }

    public int minimumTotal2(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n][n];
        dp[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                if (j == 0) dp[i][j] = dp[i - 1][j] + triangle.get(i).get(j);
                else if (j == triangle.get(i).size() - 1) dp[i][j] = dp[i - 1][j - 1]+ triangle.get(i).get(j);
                else
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j - 1])+ triangle.get(i).get(j);
            }
        }
        for (int i = 0; i < n; i++) {
            res = Math.min(res, dp[n - 1][i]);
        }
        return res;
    }
}
