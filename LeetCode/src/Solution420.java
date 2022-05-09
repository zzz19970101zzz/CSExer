import org.junit.Test;

/**
 * @author zzz
 * @create 2022-04-02-9:23
 */
public class Solution420 {
    public int strongPasswordChecker(String password) {
        int res = 0;
        int smallLetter  = 0;
        int bigLetter = 0;
        int number = 0;
        int count = 1;
        for (int i = 0; i < password.length(); i++) {
            char c = password.charAt(i);
            if(Character.isDigit(c)){
                number++;
            }
            if(Character.isLetter(c)){
                if(c >= 'a' && c <= 'z') smallLetter++;
                else bigLetter++;
            }
            if(i != 0 && c == password.charAt(i - 1)){
                count++;
            }
            if((i != 0 &&c != password.charAt(i -1) )|| i == password.length() -1){
                res += count / 3;
                count=1;
            }
        }
        int result = res;
        int other = password.length() - bigLetter - smallLetter -number;
        if(password.length() < 6){
            int lack = (number >= 1 ? 0 : 1) + (smallLetter >= 1 ? 0 : 1)
                    +(bigLetter>= 1 ? 0 : 1);
            int i = lack - res;
            return 6 - password.length() > i ? 6- password.length() : i;
        }
        if(number == 0){
            if(res != 0){
                res--;
            }else if(other !=0){
                result++;
                other--;
            }else if(smallLetter > 1){
                result++;
                smallLetter--;
            } else if(bigLetter > 1){
                result++;
                bigLetter--;
            }else {
                result++;
            }
        }
        if(bigLetter == 0){
            if(res != 0){
                res--;
            }else if(other !=0){
                result++;
                other--;
            }else if(number > 1){
                result++;
                number--;
            } else if(smallLetter > 1){
                result++;
                smallLetter--;
            }else {
                result++;
            }
        }
        if(smallLetter == 0){
            if(res != 0){
                res--;
            }else if(other !=0){
                result++;
                other--;
            }else if(number > 1){
                result++;
                number--;
            } else if(bigLetter > 1){
                result++;
                bigLetter--;
            }else {
                result++;
            }
        }
        if(password.length() > 20){
            result += password.length() -20;
        }
        return result;
    }
    @Test
    public void test(){
        System.out.println(strongPasswordChecker("1111111111"));
    }
}
