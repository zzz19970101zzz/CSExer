import org.junit.Test;

import java.util.*;

/**
 * @author zzz
 * @create 2022-03-18-15:11
 */
public class Solution16_25 {
@Test
    public void test(){
    LRUCache cache = new LRUCache(2);
    cache.put(1,1);
    cache.put(2,2);
    cache.get(1);
    cache.put(3,3);
    System.out.println(cache.get(2));
}
}
class LRUCache {

    LinkedHashMap<Integer,Integer> map;
    int maxSize;
    public LRUCache(int capacity) {
        map = new LinkedHashMap<>();
        maxSize = capacity;
    }
    public int get(int key) {
        if(map.containsKey(key)){
            Integer integer = map.get(key);
            map.remove(key);
            map.put(key,integer);
            return integer;
        }
        return -1;
    }
    public void put(int key, int value) {
       if(map.size() < maxSize){
           map.remove(key);
           map.put(key,value);
       }else {
           if(!map.containsKey(key)) {
               map.remove(map.entrySet().iterator().next().getKey());
               map.put(key,value);
           }
           else {
               map.remove(key);
               map.put(key,value);
           }
       }
    }
}