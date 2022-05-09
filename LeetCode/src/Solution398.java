import java.util.*;

/**
 * @author zzz
 * @create 2022-04-25-9:44
 */
public class Solution398 {

}
class Solution1 {
    int[] num ;
    HashMap<Integer, Random> map = new HashMap<>();
    HashMap<Integer, List<Integer>> map1 = new HashMap<>();
    public Solution1(int[] nums) {
        num = nums;
        for (int i = 0; i < nums.length; i++) {
            List<Integer> list = map1.getOrDefault(nums[i], new ArrayList<>());
            list.add(i);
            map1.put(nums[i],list);
        }
        for(Map.Entry<Integer,List<Integer>> e: map1.entrySet()){
            map.put(e.getKey(),new Random());
        }
    }

    public int pick(int target) {
        List<Integer> list = map1.get(target);
        Random random = map.get(target);
        Integer i = list.get(random.nextInt(list.size() - 1));
        return i;
    }
    public int projectionArea(int[][] grid) {
        int res = grid.length * grid[0].length;
        for (int i = 0; i < grid.length; i++) {
            int max = 0;
            for (int j = 0; j < grid[i].length; j++) {
                max = Math.max(max,grid[i][j]);
                if(grid[i][j] == 0) res--;
            }
            res += max;
        }

        for (int i = 0; i < grid[0].length; i++) {
            int max = 0;
            for (int j = 0; j < grid.length; j++) {
                max = Math.max(max,grid[j][i]);
            }
            res += max;
        }
        return res;
    }
}