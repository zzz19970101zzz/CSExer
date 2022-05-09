import org.junit.Test;

/**
 * @author zzz
 * @create 2022-02-25-9:33
 */
public class Solution537 {
    public String complexNumberMultiply(String num1, String num2) {
        int k = num1.indexOf('+');
        int m = num2.indexOf('+');
        int x1 = Integer.valueOf(num1.substring(0,k));
        int x2 = Integer.valueOf(num2.substring(0,m));

        int y1 = Integer.valueOf(num1.substring(k + 1,num1.length() -1));
        int y2 = Integer.valueOf(num2.substring(m + 1,num2.length() -1));

        int resX = x1 * x2 - y1 * y2;
        int resY = x1 * y2 + x2 * y1;
        return resX + "+" + resY + "i";
    }
    @Test
    public void test(){
        String s = "1+-1i+0i+-2i";
        String[] split = s.split("\\+|i");
        System.out.println(split.length);
        for (int i = 0; i < split.length; i++) {
            System.out.println(split[i]);
        }
        //System.out.println(complexNumberMultiply("1+-1i", "0+0i"));
    }

}
