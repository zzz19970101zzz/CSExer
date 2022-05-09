import java.util.Stack;

/**
 * @author zzz
 * @create 2022-02-23-9:33
 */
public class Solution917 {
    public String reverseOnlyLetters(String s) {
        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()){
            if(c <= 'z' && c>= 'a' || (c <= 'Z' && c>= 'A')) stack.add(c);
        }
        String res = new String();
        for(char c : s.toCharArray()){
            if(c <= 'z' && c>= 'a' || (c <= 'Z' && c>= 'A')) res += stack.pop();
            else res+=c;
        }
        return res;
    }
}
