import java.util.ArrayList;
import java.util.List;

/**
 * @author zzz
 * @create 2022-03-23-9:32
 */
public class SolutionOfferII050 {
    int res = 0;
    public int pathSum(TreeNode root, int targetSum) {
        dfs(new ArrayList<>(),root,targetSum);
        return res;
    }
    public void dfs(List<Integer> list,TreeNode root,int targrt){
        if(root == null){
            return;
        }
        List<Integer> list1 = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            list1.add(list.get(i) + root.val);
            if(list1.get(i) == targrt) res++;
        }
        if(root.val == targrt) res++;
        list1.add(root.val);
        dfs(list1,root.left,targrt);
        dfs(list1,root.right,targrt);
    }
}
