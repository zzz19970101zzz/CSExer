import org.junit.Test;

import java.util.Arrays;

/**
 * @author zzz
 * @create 2022-03-20-9:21
 */
public class Solution2039 {
    public int networkBecomesIdle(int[][] edges, int[] patience) {

        int n = patience.length;
        int[][] matrix = new int[n][n];
        for(int[] i:matrix){
            Arrays.fill(i,Integer.MAX_VALUE);
        }
        for (int i = 0; i < n; i++) {
            matrix[i][i] = 0;
        }
        for(int[] i: edges){
            matrix[i[0]][i[1]] = 1;
            matrix[i[1]][i[0]] = 1;
        }
        int[] s = new int[n];
        int[] dist = new int[n];
        int[] path = new int[n];
        for (int i = 0; i < n; i++) {
            dist[i] = matrix[0][i];
            if(matrix[i][0] == Integer.MAX_VALUE){
                path[i]  = -1;
            }else path[i] = 0;
        }
        s[0] = 1; path[0] = 0;
        for (int i = 0; i < n; i++) {
            int min  = Integer.MAX_VALUE;
            int u = -1;
            for (int j = 0; j < n; j++) {
                if(s[j] == 0 && dist[j] <min){
                    min = dist[j];
                    u = j;
                }
            }
            if(u != -1){
                s[u] = 1;
                for (int j = 0; j < n; j++) {
                    if(s[j] == 0 && matrix[u][j] < Integer.MAX_VALUE &&
                            dist[u] + matrix[u][j] <dist[j]){
                        dist[j] = dist[u] + matrix[u][j];
                        path[j] = u;
                    }
                }
            }
        }

        int res = Integer.MIN_VALUE;
        for (int i = 1; i < n; i++) {
            int first = dist[i] *2;

            if(first <= patience[i])
            {
                res =Math.max(res,first + 1);
            }else{
                int i1 =  first % patience[i] ;
                if(i1 == 0) i1 = patience[i];
                res = Math.max(res,first + first - i1  + 1);
            }
        }
        return res;
    }
    public int countCollisions(String directions) {

        if(directions.length() ==0) return 0;
        int l = 0;
        int r = directions.length();
        for (int i = 0; i < directions.length(); i++) {
            if(directions.charAt(i) != 'L' ) {
                l = i;
                break;}
        }
        for (int i = directions.length() - 1; i >= 0; i--) {
            if(directions.charAt(i) != 'R' ) {
                r = i;
                break;}
        }
        String s = directions.substring(l,r + 1);
        int res  = 0;
        int crash = 0;
        int left = 0;
        int right = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == 'R'){
                right++;
            }
            if(c == 'L'){
                if(right == 0) continue;
                int n = 1;
                for (int j = i +1; j < s.length(); j++) {
                    if(s.charAt(j) != 'L'){
                        break;
                    }
                    n++;
                }
                res+=n + right;
                right = 0;
            }
            if(c == 'S'){
                res+=right;
                int n = 0;
                for (int j = i +1; j < s.length(); j++) {
                    if(s.charAt(j) != 'L'){
                        break;
                    }
                    n++;
                }
                res += n;
                right=0;
            }
        }
        return res;
    }
    public int[] maximumBobPoints(int numArrows, int[] aliceArrows) {


        int max = 1<<12;

        int[] res = new int[12];

        int p1 = 0;
        int m = 0;
        for (int i = 0; i < max; i++) {
            boolean flag = false;
            int sum = 0;
            for (int j = 0; j <= 11; j++) {
                int p = (i>>j) % 2;
                if(p == 1){
                    sum+=(aliceArrows[11-j]+1);
                    if(sum > numArrows){
                        flag = true;
                        break;
                    }
                }
            }
            if(flag == false) {
                int score = 0;
                for (int j = 0; j <= 11; j++) {
                    if ((i >> j) % 2 == 1) score+= (11-j);
                }
                if (m < score) {
                    p1 = i;
                    m = score;
                }
            }
        }
        for (int i = 0; i < 11; i++) {
            if((p1>>i) % 2 == 1) {
            res[11 - i] = aliceArrows[11 - i] + 1;
            }
        }
        int q = 0;
        for (int i = 0; i < res.length; i++) {
            q+=res[i];
        }
        if(q<numArrows){
            for (int i = 0; i < res.length; i++) {
                if(res[i] != 0) {res[i] += numArrows-q;
                break;}
            }
        }
        System.out.println();
        return res;
    }
@Test
    public void test(){
        int i =1;
        System.out.println(i);
        maximumBobPoints(9,new int[]{1,1,0,1,0,0,2,1,0,1,2,0});
    System.out.println(countCollisions(""));
    System.out.println(networkBecomesIdle(new int[][]{{0, 1}, {1, 2}}, new int[]{0, 2, 1}));
}
}
