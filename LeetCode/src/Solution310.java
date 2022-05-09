import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * @author zzz
 * @create 2022-04-06-9:40
 */
public class Solution310 {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {

        int[][] matrix = new int[n][n];
        for(int[] i : edges){
            matrix[i[0]][i[1]] = 1;
            matrix[i[1]][i[0]] = 1;
        }
        List<Integer> res = new ArrayList<>();
        int min = 20000;
        for (int m = 0; m < n; m++) {
            HashSet<Integer> set = new HashSet<>();
            set.clear();
            LinkedList<Integer> queue = new LinkedList<>();
            queue.add(m);
            set.add(m);
            int ceng = 0;
            while (!queue.isEmpty()){
                int size = queue.size();
                while (size > 0){
                    Integer poll = queue.poll();
                    for (int i = 0; i < matrix[poll].length; i++) {
                        if(matrix[poll][i] == 1 && !set.contains(i)){
                            queue.add(i);
                            set.add(i);
                        }
                    }
                    size--;
                }
                ceng++;
            }
            if(min > ceng){
                min = ceng;
                res.clear();
                res.add(m);
            }else if(min == ceng){
                res.add(m);
            }
        }
       return res;
    }
    @Test
    public void test(){
        System.out.println(findMinHeightTrees(4, new int[][]{{1, 0}, {1, 2}, {1, 3}}));
    }
}
