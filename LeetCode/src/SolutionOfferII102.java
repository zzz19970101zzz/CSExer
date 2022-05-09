import org.junit.Test;

/**
 * @author zzz
 * @create 2022-03-19-19:15
 */
public class SolutionOfferII102 {
    int res = 0;
    public int findTargetSumWays(int[] nums, int target) {

        dfs(nums,0,0,target);
        return res;
    }
    public void dfs(int[] nums,int i,int sum,int target){
        if(i == nums.length ){
            if(sum == target)
            res++;
            return;
        }
        sum+=nums[i];
        dfs(nums,i +1,sum,target);
        sum-=nums[i] * 2;
        dfs(nums,i +1,sum,target);
    }
    static String string =new String("0");
    public static void m(String s){

        s += "1";
    }
    @Test
    public void test(){
        //m(string);
        System.out.println(string+="1");
    }

    public static void main(String[] args) {
        m(string);
        System.out.println(string);
    }
}
