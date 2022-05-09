import org.junit.Test;
import org.omg.PortableInterceptor.INACTIVE;

import java.util.*;
import java.util.concurrent.locks.Condition;

/**
 * @author zzz
 * @create 2022-04-01-9:51
 */
public class Solution954 {
    public boolean canReorderDoubled(int[] arr) {

        List<Integer> list = new ArrayList<>();
        for(int i : arr){
            list.add(i);
        }
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Math.abs(o1) - Math.abs(o2);
            }
        });
        for (int i = 0; i < arr.length; i++) {
            arr[i] = list.get(i);
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i : arr){
            map.put(i,map.getOrDefault(i,0) + 1);
        }
        for(int i : arr) {
            if(map.get(i) ==0) continue;
            if (map.containsKey(i * 2)) {
                Integer count = map.get(i * 2);
                if (count == 0) return false;
                else {
                    map.put(i,map.get(i) - 1);
                    map.put(i * 2, count - 1);
                }
            }else return false;
        }
        return true;
    }
    @Test
    public void test(){
        System.out.println(canReorderDoubled(new int[]{1,2,1,-8,8,-4,4,-4,2,-2}));
    }
}
