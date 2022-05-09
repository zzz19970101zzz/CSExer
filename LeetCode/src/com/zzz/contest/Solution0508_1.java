package com.zzz.contest;

import java.util.Arrays;
import java.util.List;

/**
 * @author zzz
 * @create 2022-05-08-10:31
 */
public class Solution0508_1 {
    public String largestGoodInteger(String num) {
        String[] strs = {"999","888","777","666","555","444","333","222","111","000"};
        List<String> list = Arrays.asList(strs);
        String res = "";
        for (int i = 0; i < num.length() - 2; i++) {
            String sub = num.substring(i, i + 3);
            if(list.contains(sub)){
                if(res == "" ||list.indexOf(sub) < list.indexOf(res)){
                    res = sub;
                }
            }
        }
        return res;
    }
}
