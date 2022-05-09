import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zzz
 * @create 2022-02-19-9:48
 */
public class Solution969 {
    public List<Integer> pancakeSort(int[] arr) {

        List<Integer> list = new ArrayList<>();
        int len = arr.length;
        for (int i = len - 1; i >= 0; i--) {
            if(arr[i] == i + 1) continue;
            if(arr[0] == i + 1){
                list.add(i + 1);
                reverse(arr,0,i);
                continue;
            }
            for (int j = 0; j < i; j++) {
                if(arr[j] == i + 1){
                    reverse(arr,0,j);
                    list.add(j + 1);
                    break;
                }
            }
            reverse(arr,0,i);
            list.add(i + 1);
        }
        return list;
    }
    public void reverse(int[] arr,int i,int j){
        while(i < j){
            int p = arr[j];
            arr[j] = arr[i];
            arr[i] = p;
            i++;
            j--;
        }
    }

    @Test
    public void test(){
        int[] a = new int[]{2,1};
        System.out.println(pancakeSort(a));
    }
}
