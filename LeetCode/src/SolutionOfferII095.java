/**
 * @author zzz
 * @create 2022-03-15-21:17
 */
public class SolutionOfferII095 {
    public int longestCommonSubsequence(String text1, String text2) {
        int len1 = text1.length();
        int len2 = text2.length();
        int[][] dp = new int[len1][len2];
        boolean flag = false;
        for (int j = 0; j < len2; j++) {
            if(text2.charAt(j) == text1.charAt(0)){
                flag = true;
            }
            dp[0][j] = flag == true?1:0;
        }
        flag = false;
        for (int i = 0; i < len1; i++) {
            if(text1.charAt(i) == text2.charAt(0)){
                flag = true;
            }
            dp[i][0] = flag == true?1:0;
        }
        for (int i = 1; i < len1; i++) {
            for (int j = 1; j < len2; j++) {
                if(text1.charAt(i) == text2.charAt(j)){
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }else {
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[len1-1][len2-1];
    }
}
