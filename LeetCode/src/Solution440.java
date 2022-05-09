
import java.util.PriorityQueue;

/**
 * @author zzz
 * @create 2022-03-23-8:58
 */
public class Solution440 {

    public int findKthNumber(int n, int k) {

        PriorityQueue<String> queue = new PriorityQueue<>();
        for (int i = 1; i <= n; i++) {
            queue.add(i+"");
        }
        int res = 0;
        while (k-->0){
            res = Integer.parseInt(queue.poll());
        }
        return res;
    }
}
