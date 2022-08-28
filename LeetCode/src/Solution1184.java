import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author zzz
 * @create 2022-07-24-9:45
 */
public class Solution1184 {
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        int res1 = 0;
        int res2 = 0;
        if(start < destination){
            int temp = start;
            start = destination;
            destination = temp;
        }
        if(start ==0 && destination == distance.length - 1){
            return distance[destination];
        }
        for (int i = start ; i < destination; i++) {
            if(i >= distance.length){
                i=0;
            }
            res1 += distance[i];
        }
        for (int i = destination ; ; i++) {
            if(i > distance.length - 1){
                i = 0;
            }
            if(i == start){
                break;
            }
            res2 += distance[i];
        }
        return Math.min(res1,res2);
    }
    public char repeatedCharacter(String s) {
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            if(set.contains(s.charAt(i)))
                return s.charAt(i);
            set.add(s.charAt(i));

        }
        return new Character(' ');
    }
    @Test
    public void test(){
        System.out.println(distanceBetweenBusStops(new int[]{1, 2, 3, 4}, 0, 1));
    }
}
