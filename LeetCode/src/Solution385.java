import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zzz
 * @create 2022-04-15-10:31
 */
class NestedInteger{
    public NestedInteger(){};
    public NestedInteger(int value){};
   public boolean isInteger(){return true;};
  public Integer getInteger(){return 0;};
    public void setInteger(int value){return;};
   public void add(NestedInteger ni){};
    public List<NestedInteger> getList(){return null;};
}
public class Solution385 {
    public NestedInteger deserialize(String s) {
        NestedInteger ni = new NestedInteger();
        NestedInteger ni1 = ni;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                int num = c - '0';
                int j = i + 1;
                for (; j < s.length(); j++) {
                    if(!Character.isDigit(s.charAt(j)))break;
                    num = num * 10 + (s.charAt(j) - '0');
                }
                ni1.add(new NestedInteger(num));
                List<NestedInteger> list = ni1.getList();
                i = j;
            }
            if(c == '['){
                List<NestedInteger> list = ni1.getList();
                ni1 = list.get(list.size() -1);
            }
        }
        return ni;
    }

    @Test
    public void test(){
        System.out.println(1.1  + 2.2);
    }
}
