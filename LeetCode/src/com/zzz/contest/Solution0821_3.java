package com.zzz.contest;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * @author zzz
 * @create 2022-08-21-11:24
 */
public class Solution0821_3 {
    ArrayList<Integer>[] lists = new ArrayList[100001];
    HashSet<Integer> set = new HashSet<>();
    public int amountOfTime(TreeNode root, int start) {
        for (int i = 0; i < lists.length; i++) {
            lists[i] = new ArrayList<>();
        }
        dfs(root);
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(start);
        set.add(start);
        int res = 0;
        while (queue.size() > 0){
            int size = queue.size();
            boolean f = false;
            while (size-->0){
                Integer poll = queue.poll();
                List<Integer> list = lists[poll];
                for(int i : list){
                    if(set.contains(i))
                        continue;
                    f = true;
                    queue.add(i);
                    set.add(i);
                }
            }
            if(f)
            res++;
        }
        return res;
    }
    public void dfs(TreeNode root){
        if(root == null)
            return;
        if(root.left ==null && root.right ==null){
            return;
        }
        if(root.left == null){
            int r = root.right.val;
            lists[root.val].add(r);
            lists[root.right.val].add(root.val);
        }
        if(root.right == null){
            int r = root.left.val;
            lists[root.val].add(r);
            lists[root.left.val].add(root.val);
        }else {
            int l = root.left.val;
            int r = root.right.val;
            lists[root.val].add(l);
            lists[root.val].add(r);
            lists[root.left.val].add(root.val);
            lists[root.right.val].add(root.val);
        }
        dfs(root.left);
        dfs(root.right);
    }
    @Test
    public  void test(){
        TreeNode rooe = new TreeNode(1);
        rooe.left = new TreeNode(2);
        rooe.right = new TreeNode(3);
        rooe.left.left = new TreeNode(4);
        System.out.println(amountOfTime(rooe, 4));
    }
}
