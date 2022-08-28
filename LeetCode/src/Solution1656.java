import java.util.ArrayList;
import java.util.List;

/**
 * @author zzz
 * @create 2022-08-16-21:42
 */
public class Solution1656 {

}
class OrderedStream {

    String[] arr;
    int ptr = 0;
    public OrderedStream(int n) {
        arr = new String[n];
    }

    public List<String> insert(int idKey, String value) {
        idKey--;
        if(idKey != ptr) {
            arr[idKey] = value;
            return new ArrayList<>();
        }
        arr[idKey] = value;
        List<String> list = new ArrayList<>();
        while (ptr < arr.length && arr[ptr] != null){
            list.add(arr[ptr++]);
        }
        return list;
    }
}
