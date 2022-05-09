import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zzz
 * @create 2022-03-16-13:39
 */
public class SolutionOfferII083 {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        dfs(new ArrayList<>(),nums,new boolean[nums.length]);
        return res;
    }
    public void dfs(List<Integer> list,int[] nums,boolean[] isvisited){
        if(list.size() == nums.length){
            res.add(new ArrayList<>(list));
            return;
        }
        for (int j = 0; j < nums.length; j++) {
            if(isvisited[j]) continue;
            isvisited[j] = true;
            list.add(nums[j]);
            dfs(list,nums,isvisited);
            isvisited[j] = false;
            list.remove(list.size() - 1);
        }
    }
    @Test
    public void test(){
        System.out.println(permute(new int[]{1, 2,3}));
    }
}
