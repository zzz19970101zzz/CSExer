/**
 * @author zzz
 * @create 2022-02-27-9:50
 */
public class Solution553 {
    public String optimalDivision(int[] nums) {

        StringBuffer sb = new StringBuffer();
        if(nums.length <= 2){
            for (int i = 0; i < nums.length; i++) {
                sb.append(nums[i] + "/");
            }
            sb.deleteCharAt(sb.length() - 1);
            return sb.toString();
        }
        sb.append(nums[0] + "/(");
        for (int i = 1; i < nums.length; i++) {
            sb.append(nums[i] + "/");
        }
        sb.append(")");
        return sb.toString();
    }
}
