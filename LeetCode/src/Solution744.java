import org.junit.Test;

/**
 * @author zzz
 * @create 2022-04-03-9:21
 */
public class Solution744 {
    public char nextGreatestLetter(char[] letters, char target) {
        int min = 26;
        char res = ' ';
        for (int i = 0; i < letters.length; i++) {
            char c = letters[i];
            if(c == target)continue;
            int i1 = c - target < 0 ? 26 + (c - target) : c - target;
            if(i1 < min){
                min = i1;
                res = c;
            }
        }
        return res;
    }

    public char nextGreatestLetter1(char[] letters, char target) {
        int min = 26;
        char res = ' ';
        int l = 0;
        int r = letters.length -1;
        while (l < r){
            int mid = (l + r) / 2;
            if(target >= letters[mid]){
                l = mid + 1;
            }else if(target < letters[mid]){
                r = mid;
            }
        }
        return letters[l] <= target ? letters[0] : letters[l];
    }


    @Test
    public void test(){
        System.out.println(nextGreatestLetter1(new char[]{'c', 'f', 'j'}, 'j'));
    }
}
