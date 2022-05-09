package com.zzz.contest;

/**
 * @author zzz
 * @create 2022-05-08-10:38
 */
public class Solution0508_2 {
    int res =0;
    public int averageOfSubtree(TreeNode root) {
        dfs(root);
        return res;
    }
    public int[] dfs(TreeNode root){
        if(root == null) return new int[]{0,0};
        int[] l = dfs(root.left);
        int[] r = dfs(root.right);
        if(root.val == (l[0] + r[0] + root.val) / (l[1] + r[1] + 1))
            res++;
        int[] res = new int[2];
        res[0] = l[0] + r[0] + root.val;
        res[1] = l[1] + r[1] + 1;
        return res;
    }
}
