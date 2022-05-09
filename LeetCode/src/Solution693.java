import org.junit.Test;

/**
 * @author zzz
 * @create 2022-03-28-10:08
 */
public class Solution693 {
    public boolean hasAlternatingBits(int n) {
        boolean flag1 = false;
        boolean flag2 = false;
        if(n %2==0) flag1=true;
        else flag2 = true;
        while (n > 0){
            if(flag1 && n % 2 != 0) return false;
            if(flag2 && n %2 == 0) return false;
            flag1 = !flag1;
            flag2=!flag2;
            n>>=1;
        }
        return true;
    }
    @Test
    public void test(){
        System.out.println(hasAlternatingBits(8));
    }
}
