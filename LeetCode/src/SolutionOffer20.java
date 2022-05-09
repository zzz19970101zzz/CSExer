import org.junit.Test;

/**
 * @author zzz
 * @create 2022-04-12-12:09
 */
public class SolutionOffer20 {
    public boolean isNumber(String s) {

        int i = 0;
        for (; i < s.length(); i++) {
            if(s.charAt(i) != ' ')break;
        }
        int q = s.length() - 1;
        for (; q >= 0; q--) {
            if(s.charAt(q) != ' ')break;
        }
        //if(q == 0)return false;
        if(q < 0)return false;
        s = s.substring(i,q + 1);
        if(s.length() == 0)return false;
        String s1 = ""; String s2 = "";
        for (int j = 0; j < s.length(); j++) {
            char c = s.charAt(j);
            if(Character.isLetter(c)){
                if(j == s.length() -1) return false;
                if(c!='e' && c!='E')return false;
                else {
                    s1 = s.substring(0,j);s2 = s.substring(j +1);
                    break;
                }
            }
            if(j == s.length() - 1){
                return issmall(s) || isInt(s);
            }
        }
        boolean b = issmall(s1) || isInt(s1);
        boolean b2 = isInt(s2);
        return b && b2;
    }
    public boolean isInt(String s){
        int p = 0;
        int q = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(!Character.isDigit(c)){
                if(c == '+' || c == '-'){
                    if(i != 0)return false;
                    p++;}else return false;
            }
            if(p > 1)return false;
            if(c>='0' && c<='9')q++;
        }
        return q>=1;
    }
    public boolean issmall(String s){
        int p = 0;
        int q = 0;
        int dot = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(!Character.isDigit(c)){
                if(c == '+' || c == '-'){
                    if(i != 0)return false;
                    p++;}
                else if(c == '.') {
//                    if (i == s.length() -1 || !Character.isDigit(s.charAt(i + 1)))
//                        return false;
                    dot++;
                }else return false;
            }

            if(p > 1)return false;
            if(c>='0' && c<='9')q++;

            if(dot > 1) return false;
        }
        return q>=1;
    }
    @Test
    public void test(){
        //System.out.println(isNumber("+12e34"));
        //System.out.println(isNumber("3."));
    }

}
