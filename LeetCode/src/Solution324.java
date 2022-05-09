import org.junit.Test;

import javax.sound.midi.Soundbank;
import java.util.Arrays;

/**
 * @author zzz
 * @create 2022-03-05-14:46
 */
public class Solution324 {
    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        int[] res = new int[nums.length];
        Arrays.fill(res,-1);
        int j = 0;
        for (int i = 0; i < res.length; i+=2) {
            res[i] = nums[j++];
        }
        for (int i = 0; i < res.length; i++) {
            if(res[i] == -1){
                res[i] = nums[j++];
            }
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = res[i];
        }
    }
    @Test
    public void test(){
        wiggleSort1(new int[]{4,5,5,5,6});
    }
    public  void wiggleSort1(int[] nums) {
        int[]bucket=new int[5001];
        for(int num:nums)bucket[num]++;
        int len=nums.length;
        int small,big;//穿插数字时的上界
        //总长度为奇数时，“小 大 小 大 小”边界左右都为较小的数；
        //总长度为偶数时，“小 大 小 大”边界左为较小的数，边界右为较大的数
        if((len&1)==1){
            small=len-1;
            big=len-2;
        }else{
            small=len-2;
            big=len-1;
        }
        int j=5000; //从后往前，将桶中数字穿插到数组中，后界为j
        //桶中大的数字在后面，小的数字在前面，所以先取出较大的数字，再取出较小的数字
        //先将桶中的较大的数字穿插放在nums中
        for(int i=1;i<=big;i+=2){
            while (bucket[j]==0)j--;//找到不为0的桶
            nums[i]=j;
            bucket[j]--;
        }
        //再将桶中的较小的数字穿插放在nums中
        for(int i=0;i<=small;i+=2){
            while (bucket[j]==0)j--;//找到不为0的桶
            nums[i]=j;
            bucket[j]--;
        }
        System.out.println();
    }
//    作者：fszhang/.业转载请注明出处。
}
