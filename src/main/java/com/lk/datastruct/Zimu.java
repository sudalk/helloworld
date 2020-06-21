package com.lk.datastruct;

import java.util.*;

/*
第一种就是排序
第二种就是乘积
 */
public class Zimu {

    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs.length == 0) return new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for(String str:strs){
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = String.valueOf(chars);
            if(!map.containsKey(key)){
                map.put(key,new ArrayList<String>());
            }
            map.get(key).add(str);
        }
        return new ArrayList<List<String>>(map.values());
    }
}
