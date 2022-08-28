import org.junit.Test;

import java.util.*;

/**
 * @author zzz
 * @create 2022-08-25-22:49
 */
public class Solution658 {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {

        PriorityQueue<int[]> queue = new PriorityQueue<>();
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i] - x;
            map.put(arr[i],map.getOrDefault(arr[i],0) + arr[i]);
        }
        List<Integer> list = new ArrayList<>();
        for(Map.Entry<Integer,Integer> e : map.entrySet()){
            if(list.size() == k)
                break;
            if(e.getKey() == 0){
                list.add(x);
                continue;
            }
            list.add(x - e.getKey());
            if(list.size() == k)
                break;
            if(e.getValue() > 1)
            list.add(x + e.getKey());
        }
        Collections.sort(list);
        return list;
    }
    @Test
    public void test(){
//        System.out.println(findClosestElements(new int[]{1, 2, 3, 4, 5}, 4, 3));
        System.out.println(findClosestElements(new int[]{1, 2, 3, 4, 5}, 4, -1));

    }
}
