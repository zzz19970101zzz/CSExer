/**
 * @author zzz
 * @create 2022-03-25-9:08
 */
public class Solution172 {
    public int trailingZeroes(int n) {
        int res = 0;
        for (int i = 1; i <= n; i++) {
            int num = i;
            while (num >= 5){
                if(num % 5 == 0){
                    num /=5;
                    res++;
                }else break;
            }
        }
        return res;
    }
}
