import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author zzz
 * @create 2022-05-07-9:44
 */
public class Solution433 {
    public int minMutation(String start, String end, String[] bank) {

        List<String> list = new ArrayList<>();
        List<Boolean> l = new ArrayList<>();
        for(String s : bank){
            list.add(s);
            l.add(false);
        }
        LinkedList<String> queue = new LinkedList<>();
        String[] ch = new String[]{"A","C","G","T"};
        queue.add(start);
        int ceng = 0;
        while (!queue.isEmpty()){
            int size = queue.size();
            while (size > 0){
                String poll = queue.poll();
                if(poll.equals(end))
                    return ceng;
                for (int i = 0; i < poll.length(); i++) {
                    for (int j = 0; j < ch.length; j++) {
                        String p = poll.substring(0,i) + ch[j] + poll.substring(i + 1);
                        if(list.contains(p)){
                            int i1 = list.indexOf(p);
                            if(!l.get(i1))
                                queue.add(p);
                            l.set(i1,true);
                        }
                    }
                }
                size--;
            }
            ceng++;
        }
        return -1;
    }
    @Test
    public void test(){
//        System.out.println(minMutation("AACCGGTT",
//                "AACCGCTA", new String[]{"AACCGGTA",
//                        "AACCGCTA", "AAACGGTA"}));
//        System.out.println(minMutation("AGCAAAAA",
//                "GACAAAAA", new String[]{"AGTAAAAA",
//                        "GGTAAAAA", "GATAAAAA","GACAAAAA"}));
        String s = "123";
        System.out.println(s.substring(s.length()));
    }
}
