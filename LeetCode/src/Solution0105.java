/**
 * @author zzz
 * @create 2022-05-13-9:28
 */
public class Solution0105 {
    public boolean oneEditAway(String first, String second) {
        int flen = first.length();
        int slen = second.length();
        int abs = Math.abs(slen - flen);
        if(abs >= 2) return false;
        if(abs == 1){
            return m(second,first);
        }else {
            int o = 1;
            for (int i = 0; i < slen; i++) {
                if(first.charAt(i) != second.charAt(i)) o--;
                if(o < 0) return false;
            }
            return true;
        }
    }
    public boolean m(String s1,String s2){
        String s11 = s1.length() > s2.length() ? s1:s2;
        String s22 = s1.length() < s2.length() ? s1:s2;
        int o = 0;
        String s = "";
        for (int i = 0; i < s22.length(); i++) {
            if(s11.charAt(i) != s22.charAt(i)){
                s = s11.substring(0,i) + s11.substring(i + 1);
                return s.equals(s22);
            }
        }
        return true;
    }
}
