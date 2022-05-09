/**
 * @author zzz
 * @create 2022-03-27-9:24
 */
public class Solution2028 {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int[] res = new int[n];
        int sum = mean * (n + rolls.length);
        int rsum = 0;
        for(int i : rolls){
            rsum+=i;
        }
        int nsum = sum - rsum;
        int avg = nsum / n;

        if(avg > 6 || avg <= 0)return new int[0];
        for (int i = 0; i < res.length; i++) {
            res[i] = avg;
        }
        int s = 0;
        for (int i = 0; i < res.length; i++) {
            s+=res[i];
        }
        int p = nsum - s;
        int j = 0;
        while (p > 0){
            res[j++]++;
            p--;
        }
        for (int i = 0; i < res.length; i++) {
            if(res[i] > 6) return new int[0];
        }
        return res;
    }
}
