/**
 * @author zzz
 * @create 2022-02-22-16:48
 */
public class Solution717 {
    public boolean isOneBitCharacter(int[] bits) {

        for (int i = 0; i < bits.length; i++) {
            if(bits[i] == 1){
                i ++;
            }
            if(bits[i] == 0 && i == bits.length -1){
                return true;
            }
        }
        return false;
    }
}
