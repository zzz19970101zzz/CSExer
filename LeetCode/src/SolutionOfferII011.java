import org.junit.Test;

/**
 * @author zzz
 * @create 2022-03-15-13:59
 */
public class SolutionOfferII011 {
    public int findMaxLength(int[] nums) {

        int[] arr1 = new int[nums.length + 1];
        for (int i = 1; i < arr1.length; i++) {
            arr1[i]  = arr1[i -1 ] + nums[i - 1];
        }
        int[] arr2 = new int[nums.length + 1];
        for (int i = 1; i < arr1.length; i++) {
            if(nums[i - 1] ==0){
                arr2[i]  = arr2[i - 1 ] + 1;
            }else {
                arr2[i] = arr2[i -1];
            }
        }
        for (int i = arr1.length; i >= 0; i--) {
            int l = 0;
            int r = i - 1;
            while (r < arr1.length){
                if(arr1[r] - arr1[l] == arr2[r] - arr2[l])
                    return i - 1;
                l ++;
                r ++;
            }
        }
        return 0;
    }
    @Test
    public void test(){
        System.out.println(findMaxLength(new int[]{0, 1, 0}));
    }
}
