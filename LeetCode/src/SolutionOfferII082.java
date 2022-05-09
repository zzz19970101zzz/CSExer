import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zzz
 * @create 2022-03-16-11:29
 */
public class SolutionOfferII082 {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        Arrays.sort(candidates);
        dfs(candidates,target,new ArrayList<>(),0,0);
        return res;
    }
    public void dfs(int[] candidates,int target,List<Integer> list,int sum,int i){
        if(sum == target){
            res.add(new ArrayList<>(list));
            return;
        }
        for (int j = i ; j < candidates.length; j++) {
            if(candidates[j] > target)continue;
            if(j > i && candidates[j] == candidates[j - 1]) continue;
            list.add(candidates[j]);
            sum+= candidates[j];
            dfs(candidates,target,list,sum,j + 1);
            sum-=candidates[j];
            list.remove(list.size() - 1);
        }
    }
    @Test
    public void test(){
        System.out.println(combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8));
    }
}
