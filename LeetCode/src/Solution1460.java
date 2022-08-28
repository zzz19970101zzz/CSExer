import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zzz
 * @create 2022-08-24-19:52
 */
public class Solution1460 {
    public boolean canBeEqual(int[] target, int[] arr) {
        HashMap<Integer, Integer> m1 = new HashMap<>();
        HashMap<Integer, Integer> m2 = new HashMap<>();

        for(int i : target){
            m1.put(i,m1.getOrDefault(i,0) + 1);
        }
        for(int i : arr){
            m2.put(i,m2.getOrDefault(i,0) + 1);
        }
        for(Map.Entry<Integer,Integer> e : m1.entrySet()){
            if(!m2.containsKey(e.getKey()) || e.getValue() != m2.get(e.getKey()))
                return false;
        }
        return true;
    }
    @Test
    public void test(){
        System.out.println(canBeEqual(new int[]{1, 2, 3, 4}, new int[]{4, 3, 1, 2}));
    }
}
