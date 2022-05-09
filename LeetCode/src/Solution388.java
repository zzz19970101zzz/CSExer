import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author zzz
 * @create 2022-04-20-10:11
 */
public class Solution388 {
    public int lengthLongestPath(String input) {
        String[] arr = input.split("\n");
        List<List<String>> list = new ArrayList<>();
        int maxlen = 0;
        for(String s : arr){
            int m = m(s);
            if(s.contains(".")){
                if(m == 0){
                    maxlen = Math.max(maxlen,s.length() - m);
                }else {
                    List<String> list1 = list.get(m - 1);
                    maxlen = Math.max(maxlen,(list1.get(list1.size() - 1) + s).length() -  m);
                }
               continue;
            }
            if(m == 0){
                if(list.isEmpty()){
                    List<String> list1 = new ArrayList<>();
                    list1.add(s + "/");
                    list.add(list1);
                }else{
                    list.get(0).add(s + "/");
                }
            }else {
                if(list.size() < m + 1) {
                    List<String> list1 = new ArrayList<>();
                    list1.add(list.get(m - 1).get(list.get(m - 1).size() - 1) + s.substring(m)  +"/");
                    list.add(list1);
                }else {
                    List<String> list1 = list.get(m - 1);
                    list.get(m).add(list1.get(list1.size() - 1) + s.substring(m) + "/");
                }
            }
        }
        return maxlen;
    }
    public int m(String s){
        String s1 = s.replace("\t", "");
        return (s.length() - s1.length()) ;
    }
    public String toGoatLatin(String sentence) {
        String[] arr = sentence.split(" ");
        String s1  = "a";
        String res = "";
        for (int i = 0; i < arr.length; i++) {
            String s = arr[i];
            char c = s.charAt(0);
            if(c == 'a' || c == 'e' ||c == 'i' ||c == 'A'||
                    c == 'o' ||c == 'u' ||c == 'E'||c == 'I'||c == 'O'||c == 'U')
                s += "ma";
            else {
                s += s.charAt(0);
                s = s.substring(1) + "ma";
            }
            s+=s1;
            s1+="a";
            res += s+ " ";
        }
        return res.trim();
    }
    @Test
    public void test(){
//        System.out.println(lengthLongestPath(
//                "dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext"));
//
//        System.out.println(lengthLongestPath("a\n\tb1\n\t\tf1.txt\n\taaaaa\n\t\tf2.txt"));
        System.out.println(lengthLongestPath("a\n\tb.txt\na2\n\tb2.txt"));
    }
}
