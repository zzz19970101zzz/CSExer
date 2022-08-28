import java.util.LinkedList;
import java.util.List;

/**
 * @author zzz
 * @create 2022-08-07-9:42
 */
public class Solution636 {
    public int[] exclusiveTime(int n, List<String> logs) {

        LinkedList<int[]> stack = new LinkedList<>();
        int[] res = new int[n];
        for (int i = 0; i < logs.size(); i++) {
            String[] arr = logs.get(i).split(":");
            int no = Integer.parseInt(arr[0]);
            boolean isStart = arr[1].equals("start") ? true : false;
            if(isStart){

            }else {

            }
        }
        return res;
    }
}
