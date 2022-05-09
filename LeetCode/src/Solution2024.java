import org.junit.Test;

/**
 * @author zzz
 * @create 2022-03-29-9:55
 */
public class Solution2024 {
    public int maxConsecutiveAnswers(String answerKey, int k) {

        if(answerKey.length() == 1)return 1;
        int i = 0;
        int j = 0;
        int res = 0;
        int n1 = 0;
        int n2 = 0;
        while (i < answerKey.length()){

            while (j < answerKey.length()){
                if(answerKey.charAt(j) == 'T') n1++;
                else n2++;
                j++;
                if( Math.min(n1 , n2) <= k ){
                    res = Math.max(res,n1 + n2 );
                }else if( Math.min(n1 , n2) > k ){
                    break;
                }

            }
            if(answerKey.charAt(i) == 'T') n1--;
            else n2--;
            i++;
        }
        return res;
    }
    @Test
    public void test(){
        System.out.println(maxConsecutiveAnswers("TTFTTFTT", 1));
    }
}
