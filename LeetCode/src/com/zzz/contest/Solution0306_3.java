package com.zzz.contest;


import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * @author zzz
 * @create 2022-03-06-11:24
 */
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
public class Solution0306_3 {
    public TreeNode createBinaryTree(int[][] descriptions) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < descriptions.length; i++) {
            set.add(descriptions[i][0]);
        }
        for (int i = 0; i < descriptions.length; i++) {
            if(set.contains(descriptions[i][1]))
            set.remove(descriptions[i][1]);
        }
        TreeNode root = null;
        HashMap<Integer, Integer[]> map = new HashMap<>();
        for(Integer i : set){
            root = new TreeNode(i);
        }
        for (int i = 0; i < descriptions.length; i++) {
            Integer[] childs = map.getOrDefault(descriptions[i][0],new Integer[2]);
            if(descriptions[i][2] == 1) childs[1] = descriptions[i][1];
            else  childs[0] = descriptions[i][1];
            map.put(descriptions[i][0],childs);
        }
        dfs(map,root);
        return root;
    }
    public void dfs( HashMap<Integer, Integer[]> map ,TreeNode root){

        if(!map.containsKey(root.val)) return;
        Integer[] childs = map.get(root.val);
        if(childs[0] != null) {
            TreeNode right = new TreeNode(childs[0]);
            root.right = right;
            dfs(map,right);
        }
        if(childs[1] != null) {
            TreeNode left = new TreeNode(childs[1]);
            root.left = left;
            dfs(map,left);
        }
    }
    @Test
    public void test(){
        System.out.println(createBinaryTree(new int[][]{{20, 15, 1}, {20, 17, 0}, {50, 20, 1}, {50, 80, 0}, {80, 19, 1}}));
    }
}
