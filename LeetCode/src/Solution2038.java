/**
 * @author zzz
 * @create 2022-03-22-9:03
 */
public class Solution2038 {
    public boolean winnerOfGame(String colors) {

        int a = 0;
        int b = 0;
        for (int i = 1; i < colors.length() - 1; i++) {
            if(colors.charAt(i) == colors.charAt(i -1) &&
                colors.charAt(i) == colors.charAt(i+1)){
                if(colors.charAt(i) == 'A') a++;
                else b++;
            }
        }
        return a > b;
    }
}
