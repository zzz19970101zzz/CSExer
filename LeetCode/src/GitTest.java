<<<<<<< HEAD
=======
import org.junit.Test;

import java.util.*;

>>>>>>> 2c7739d (提交)
/**
 * @author zzz
 * @create 2023-03-11-16:16
 */
public class GitTest {
    public static void main(String[] args) {
        
    }
<<<<<<< HEAD
=======
    public int maxScore(int[] nums) {
        PriorityQueue<Integer> q1 = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        PriorityQueue<Integer> q2 = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] > 0){
                q1.add(nums[i]);
            }else {
                q2.add(nums[i]);
            }
        }
        int res = 0;
        int sum = 0;
        while (!q1.isEmpty()){
            sum += q1.poll();
            res ++;
            while (!q2.isEmpty()){
                if(q2.peek() + sum <= 0){
                    break;
                }
                sum += q2.poll();
                res ++;
            }
        }
        return res;
    }
    public long beautifulSubarrays(int[] nums) {
        long res = 0;
        long[] arr = new long[100000] ;
        for (int i = 1; i < arr.length; i++) {
            arr[i] = arr[i - 1] + i;
        }
        HashMap<Integer, Long> map = new HashMap<>();
        int num = 0;
        for(int n : nums){
            map.put(num,map.getOrDefault(num,0L) + 1);
            num ^= n;
        }
        map.put(num,map.getOrDefault(num,0L) + 1);
        for(Map.Entry<Integer,Long> e : map.entrySet()){
            if (e.getValue() == 1)continue;
            res += arr[(int) (e.getValue() - 0) - 1];
        }
        System.out.println();
        return res;
    }
    @Test
    public void test(){
        System.out.println(beautifulSubarrays(new int[]{4, 3, 1, 2, 4}));
    }
>>>>>>> 2c7739d (提交)
}
