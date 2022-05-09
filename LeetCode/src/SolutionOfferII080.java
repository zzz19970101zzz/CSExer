import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zzz
 * @create 2022-03-17-13:12
 */
public class SolutionOfferII080 {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        dfs(n,k,new ArrayList<>(),1);
        return res;
    }
    public void dfs(int n,int k,List<Integer> list,int curr){
        if(list.size() == k){
            res.add(new ArrayList<>(list));
            return;
        }
        if(curr > n) return;
        dfs(n,k,list,curr+ 1);
        list.add(curr);
        dfs(n,k,list,curr+1);
        list.remove(list.size()- 1);
    }
    @Test
    public void test(){
        System.out.println(combine(5, 3));
    }
}
