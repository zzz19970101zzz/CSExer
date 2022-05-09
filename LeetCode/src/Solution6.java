import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author zzz
 * @create 2022-03-01-9:38
 */
public class Solution6 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            new Thread(() -> {
                list.add(UUID.randomUUID().toString().substring(0,8));
                System.out.println(list);
            }).start();
        }
    }
    public String convert(String s, int numRows) {
        if(s.length() == 0 || numRows == 1) return s;
        List<List<Character>> lists = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            lists.add(new ArrayList<Character>());
        }
        int ceng = 0;
        for (int i = 0; i < s.length();) {
            if( ceng % (numRows - 1) == 0){
                for (int j = 0; j < lists.size(); j++) {
                    if(i >= s.length()) break;
                    lists.get(j).add(s.charAt(i++));
                }
            }else {
                int index = ceng % (numRows - 1);
                if(i >= s.length()) break;
                lists.get(numRows - 1 -index ).add(s.charAt(i++));
                for (int j = 0; j < numRows; j++) {
                    if(j == numRows - 1 -index) continue;
                    lists.get(j).add(' ');
                }
            }
            ceng++;
        }
        String res = "";
        for(List<Character> l : lists){
            for(Character c : l){
                if(c != ' ') res += c;
            }
        }
        return res;
    }
    @Test
    public void test(){

        System.out.println(convert("PAYPALISHIRING", 3));
    }
}
