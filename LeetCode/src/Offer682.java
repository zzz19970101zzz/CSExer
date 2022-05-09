import java.util.*;

/**
 * @author zzz
 * @create 2022-03-26-9:53
 */
public class Offer682 {
    public static void main(String[] args) {
    }
    public int calPoints(String[] ops) {
        List<Integer> list = new ArrayList<>();
        for(String s : ops){
           if(s.equals("+")){
            int i = list.get(list.size() - 1) + list.get(list.size() - 2);
            list.add(i);
           }else if(s.equals("D")){
               Integer i = list.get(list.size() - 1);
               list.add(i *2);
           }else if(s.equals("C")){
            list.remove(list.size() -1);
           }else {
               list.add(Integer.parseInt(s));
           }
        }
        int sum = 0;
        for(int i:list){
            sum+=i;
        }
        return sum;
    }
}
