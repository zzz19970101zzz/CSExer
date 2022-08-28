package com.zzz.contest;

import java.util.LinkedList;

/**
 * @author zzz
 * @create 2022-07-31-9:46
 */
public class Solution1161 {
    public int maxLevelSum(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int res = 0;
        int sum = 0;
        int max = Integer.MIN_VALUE;
        int ceng = 0;
        while (!queue.isEmpty()){
            int size = queue.size();
            sum = 0;
            while (size > 0){
                TreeNode poll = queue.poll();
                if(poll.left != null)
                    queue.add(poll.left);
                if(poll.right != null)
                    queue.add(poll.right);
                sum += poll.val;
                size--;
            }
            ceng++;
            if(sum > max){
                res = ceng;
            }
            max = Math.max(sum,max);
        }
        return res;
    }
}
