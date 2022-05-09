import org.junit.Test;

import java.util.*;

/**
 * @author zzz
 * @create 2022-04-17-9:55
 */
public class Solution819 {
    public String mostCommonWord(String paragraph, String[] banned) {
        List<String> list = new ArrayList<>();
        for(String s : banned){
            list.add(s);
        }
        List<String> wrods = new ArrayList<>();
        String s1 = "";
        for (int i = 0; i < paragraph.length(); i++) {
            if(!Character.isLetter(paragraph.charAt(i)) ){
                wrods.add(s1);
                s1 = "";
            } else s1 += paragraph.charAt(i);
        }
        wrods.add(s1);
        HashMap<String, Integer> map = new HashMap<>();
        for(String s : wrods){
            if(s .equals( "")) continue;
            if(!Character.isLetter(s.charAt(s.length() -1 )) ){
                s = s.substring(0,s.length() -1);
            }
            s = s.toLowerCase();
            map.put(s,map.getOrDefault(s,0) + 1);
        }
        PriorityQueue<Map.Entry<String, Integer>> queue = new PriorityQueue<>(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });
        for(Map.Entry<String,Integer> e : map.entrySet()){
            queue.add(e);
        }
        while (!queue.isEmpty()){
            Map.Entry<String, Integer> poll = queue.poll();
            if(!list.contains(poll.getKey())) return poll.getKey();
        }
        return null;
    }
    @Test
    public void test(){
        System.out.println(mostCommonWord(
                "Bob hit a ball, the hit BALL flew far after it was hit.",
                new String[]{"hit"}));
        System.out.println(mostCommonWord(
                "Bob",
                new String[]{}));
    }
}
