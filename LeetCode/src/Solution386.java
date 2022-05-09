import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author zzz
 * @create 2022-04-18-9:18
 */
public class Solution386 {
    public List<Integer> lexicalOrder(int n) {
        PriorityQueue<String> queue = new PriorityQueue<>();
        for (int i = 1; i <= n; i++) {
            queue.add(i + "");
        }
        List<Integer> list = new ArrayList<>();
        while (!queue.isEmpty()){
           list.add( Integer.parseInt(queue.poll()));
        }
        return list;
    }
}
