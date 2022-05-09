import org.junit.Test;

/**
 * @author zzz
 * @create 2022-03-07-9:14
 */
public class Solution504 {
    public String convertToBase7(int num) {
        StringBuffer sb = new StringBuffer();
        boolean isMinus = false;
        if(num <0) {
            num = -num;
            isMinus = true; }
        while (num >= 7){
            sb.append(num % 7);
            num /= 7;
        }
        StringBuffer reverse = sb.append(num);
        if(isMinus) reverse.append('-');
        return sb.reverse().toString();
    }
    @Test
    public void test(){
        System.out.println(convertToBase7(-7));
    }
}
