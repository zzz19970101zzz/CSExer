import org.junit.Test;

/**
 * @author zzz
 * @create 2022-03-03-9:40
 */
public class Solution258 {
    public int addDigits(int num) {

        while (num >= 10){
            int n = num % 10;
            while (true){
                num /= 10;
                n += num % 10;
                if(num < 10) break;
            }
            num = n;
        }
        return num;
    }
    @Test
    public void test(){
        System.out.println(addDigits(0));
    }
}
