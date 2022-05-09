import java.util.ArrayList;
import java.util.List;

/**
 * @author zzz
 * @create 2022-03-08-14:25
 */
public class Solution189 {
    public void rotate(int[] nums, int k) {
        k = k  % nums.length;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            list.add(nums[i]);
        }
        for (int i = 0; i < nums.length; i++) {
            if(i < k){
                nums[i] = list.get(list.size() - k + i);
            }else {
                nums[i]  = list.get(i - k);
            }
        }
    }
}
