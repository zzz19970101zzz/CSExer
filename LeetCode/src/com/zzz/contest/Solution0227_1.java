package com.zzz.contest;

/**
 * @author zzz
 * @create 2022-02-27-10:37
 */
public class Solution0227_1 {
    public int prefixCount(String[] words, String pref) {

        int res = 0;
        for (int i = 0; i < words.length; i++) {
         if(words[i].length() < pref.length()) continue;
            if(isPrefix(words[i],pref)) res++;
        }
        return res;
    }
    public boolean isPrefix(String s,String prefix){
        for (int i = 0; i < s.length(); i++) {
            if(i < prefix.length() && prefix.charAt(i) != s.charAt(i)){
                return false;
            }
        }
        return true;
    }
}
