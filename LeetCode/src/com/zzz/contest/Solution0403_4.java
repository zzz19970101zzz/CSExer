package com.zzz.contest;

import java.io.DataInput;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author zzz
 * @create 2022-04-03-11:57
 */
public class Solution0403_4 {
    public static void main(String[] args) {
        Encrypter1 encrypter = new Encrypter1(new char[]{'a','b','c','z'}, new String[]{"aa","bb","cc","zz"},
                new String[]{"aa","aaa","aaaa","aaaaa"});
        System.out.println(encrypter.decrypt("aaaa"));
        System.out.println(encrypter.decrypt("aa"));

    }
}
class Encrypter {

    char[] k; String[] v;
    ArrayList<String> d = new ArrayList<>();
    HashMap<Character, String> map = new HashMap<Character, String>();
    public Encrypter(char[] keys, String[] values, String[] dictionary) {
        k = keys;v = values;
        for (int i = 0; i < keys.length; i++) {
            map.put(keys[i],values[i]);
        }
        for(String s : dictionary){
            d.add(s);
        }
    }
    public String encrypt(String word1) {
        String res = "";
        for (int i = 0; i < word1.length(); i++) {
            char c = word1.charAt(i);
            res += map.get(c);
        }
        return res;
    }

    public int decrypt(String word2) {
        List<String> res = new ArrayList<>();
        dfs(k,v,word2,new StringBuffer(),0, res);
        return res.size();
    }
    public void dfs(char[] keys,String[] values,String s,StringBuffer sb,int i,List<String> res){
        if(sb.length() == s.length()/2){
            if(d.contains(sb.toString()))
            res.add(sb.toString());
            return;
        }
        String substring = s.substring(i, i + 2);
        for (int j = 0; j < values.length; j++) {
            if(values[j].equals(substring)){
                sb.append(keys[j]);
                dfs(keys,values,s,sb,i + 2, res);
                sb.deleteCharAt(sb.length() -1);
            }
        }
    }
}
class Encrypter1 {
    char[] k;
    String[] v;
    ArrayList<String> d = new ArrayList<>();
    HashMap<Character, String> map = new HashMap<Character, String>();
    HashMap<String, Integer> map1 = new HashMap<String, Integer>();

    public Encrypter1(char[] keys, String[] values, String[] dictionary) {
        k = keys;
        v = values;
        for (int i = 0; i < keys.length; i++) {
            map.put(keys[i], values[i]);
        }
        for (String s : dictionary) {
            d.add(s);
        }
        for (String s : d) {
            String encrypt = encrypt(s);
            map1.put(encrypt, map1.getOrDefault(encrypt, 0) + 1);
        }
    }

    public String encrypt(String word1) {
        String res = "";
        for (int i = 0; i < word1.length(); i++) {
            char c = word1.charAt(i);
            res += map.get(c);
        }
        return res;
    }

    public int decrypt(String word2) {

        return map1.get(word2) == null ? 0 : map1.get(word2);
    }
}