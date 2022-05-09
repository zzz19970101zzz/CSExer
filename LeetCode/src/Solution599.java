import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zzz
 * @create 2022-03-14-9:12
 */
public class Solution599 {
    public String[] findRestaurant(String[] list1, String[] list2) {

        int i = 0;
        int j = 0;
        int minSum = Integer.MAX_VALUE;
        List<String> list = new ArrayList<>();
        for (int k = 0; k < list1.length; k++) {
            if(k > minSum) continue;
            for (int l = 0 ; l < list2.length; l++) {
                if(l + k > minSum) continue;
                if(list1[k] .equals(list2[l])) {
                    minSum = Math.min(l + k,minSum);
                }
            }
        }
        for (int k = 0; k < list1.length; k++) {
            if( minSum - k >=0 &&minSum - k < list2.length && list1[k].equals(list2[ minSum - k ])){
                list.add(list1[k]);
            }
        }
        String[] res = new String[list.size()];
        for (int k = 0; k < res.length; k++) {
            res[k] = list.get(k);
        }
        return res;
    }
    int res = 0;
    public int numSubarrayProductLessThanK(int[] nums, int k) {

        for (int i = 0; i < nums.length; i++) {
            dfs(nums,k,i,nums[i]);
        }
        return res;
    }
    public void dfs(int[] nums,int k,int i,long multi){
        if(multi >= k || i >= nums.length){
            return;
        }
        res++;
        if(i  +1 < nums.length)
        multi *= nums[i + 1];
        dfs(nums,k,i + 1,multi);
    }
    @Test
    public void test(){
        System.out.println(numSubarrayProductLessThanK(new int[]{10, 5, 2,6}, 100));
    }
}
