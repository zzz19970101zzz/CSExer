package com.zzz.contest;


import javax.swing.*;
import java.util.*;

/**
 * @author zzz
 * @create 2022-07-24-10:56
 */
public class Solution0724_3 {
//["FoodRatings","changeRating","highestRated","changeRating","changeRating","changeRating","highestRated","highestRated"]
//        [[["emgqdbo","jmvfxjohq","qnvseohnoe","yhptazyko","ocqmvmwjq"],["snaxol","snaxol","snaxol","fajbervsj","fajbervsj"],
//        [2,6,18,6,5]],
//        ["qnvseohnoe",11],["fajbervsj"],["emgqdbo",3],["jmvfxjohq",9],["emgqdbo",14],["fajbervsj"],["snaxol"]]
    public static void main(String[] args) {
//        FoodRatings fr = new FoodRatings(new String[]{"kimchi", "miso", "sushi", "moussaka", "ramen", "bulgogi"},
//                new String[]{"korean", "japanese", "japanese", "greek", "japanese", "korean"}, new int[]{9, 12, 8, 15, 14, 7});
//        System.out.println(fr.highestRated("korean"));
//        System.out.println(fr.highestRated("japanese"));
//        fr.changeRating("sushi",16);
//        //System.out.println(fr.highestRated("korean"));
//        System.out.println(fr.highestRated("japanese"));
//        fr.changeRating("ramen",16);
////        System.out.println(fr.highestRated("japanese"));
//        FoodRatings fr = new FoodRatings(new String[]{"emgqdbo","jmvfxjohq","qnvseohnoe","yhptazyko","ocqmvmwjq"},
//                new String[]{"snaxol","snaxol","snaxol","fajbervsj","fajbervsj"}, new int[]{2,6,18,6,5});
//
//        fr.changeRating("qnvseohnoe",11);
//        //System.out.println(fr.highestRated("korean"));
//        System.out.println(fr.highestRated("fajbervsj"));
//        fr.changeRating("emgqdbo",3);
//        fr.changeRating("jmvfxjohq",9);fr.changeRating("emgqdbo",14);
//        System.out.println(fr.highestRated("fajbervsj"));
//        System.out.println(fr.highestRated("snaxol"));
        FoodRatings f = new FoodRatings(new String[]{"b"}, new String[]{"o"}, new int[]{13});
        f.changeRating("b",9);
        f.changeRating("b",6);
    }
}
class FoodRatings {

    HashMap<String , TreeMap<Integer,TreeSet<String>>> map = new HashMap();
    HashMap<String,String> map1 = new HashMap<>();
    HashMap<String,Integer> map2 = new HashMap<>();
    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        for (int i = 0; i < foods.length; i++) {
            map1.put(foods[i], cuisines[i]);
            map2.put(foods[i],ratings[i]);
            if(!map.containsKey(cuisines[i])){
                TreeMap<Integer, TreeSet<String>> m1 = new TreeMap<>(new Comparator<Integer>() {
                    @Override
                    public int compare(Integer o1, Integer o2) {
                        return o2.compareTo(o1);
                    }
                });
                TreeSet<String> set = new TreeSet<>();
                set.add(foods[i]);
                m1.put(ratings[i],set);
                map.put(cuisines[i],m1);
            }else {
                TreeMap<Integer, TreeSet<String>> m2 = map.get(cuisines[i]);
                TreeSet<String> set = m2.getOrDefault(ratings[i],new TreeSet<>());
                set.add(foods[i]);
                if(!m2.containsKey(ratings[i])){
                    m2.put(ratings[i],set);
                }
            }
        }
    }

    public void changeRating(String food, int newRating) {
        String c = map1.get(food);
        Integer r = map2.get(food);
        TreeMap<Integer, TreeSet<String>> m1 = map.get(c);
        TreeSet<String> set = m1.get(r);
        set.remove(food);
        if(set.isEmpty())
            m1.remove(r);
        TreeSet<String> set1 = m1.getOrDefault(newRating,new TreeSet<>());
        set1.add(food);
        if(!m1.containsKey(newRating))
            m1.put(newRating,set1);
        map2.put(food,newRating);
    }

    public String highestRated(String cuisine) {
        TreeMap<Integer, TreeSet<String>> m1 = map.get(cuisine);
        TreeSet<String> set = m1.firstEntry().getValue();
        return set.first();
    }
}