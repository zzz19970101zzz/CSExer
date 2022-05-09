import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

/**
 * @author zzz
 * @create 2022-04-13-9:12
 */
public class Solution380 {
    @Test
    public void test(){
        RandomizedSet r = new RandomizedSet();
        r.insert(0);
        r.insert(1);
        r.remove(0);
        //System.out.println(r.getRandom());

        //System.out.println(r.remove(1));
        r.insert(2);
        r.remove(1);
        System.out.println(r.getRandom());
    }
}
class RandomizedSet {
    List<Integer> list;
    Random random ;
    public RandomizedSet() {
        list  = new ArrayList<>();
        random = new Random();
    }

    public boolean insert(int val) {
        if(list.contains(val)) return false;
        list.add(val);
        return true;
    }

    public boolean remove(int val) {
        if(list.contains(val)){
            list.remove(new Integer(val));
            return true;
        }
        return false;
    }

    public int getRandom() {
        int r = random.nextInt(list.size());
        return list.get(r);
    }
}
