import org.junit.Test;

/**
 * @author zzz
 * @create 2022-03-23-10:13
 */
public class SolutionOfferII020 {
    public int countSubstrings(String s) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                if(check(s.substring(i,j)))res++;
            }
        }
        return res;
    }
    public boolean check(String s){
        int l = 0;
        int r = s.length() - 1;
        while (l < r){
            if(s.charAt(l) != s.charAt(r))return false;
            l++;r--;
        }
        return true;
    }
    @Test
    public void test(){
        System.out.println(countSubstrings("aaa"));
    }
}
