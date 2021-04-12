package org.self.algorithm.real;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个字符串，找出最长的没有重复的子串
 * 12343   ->   1234
 */
public class Demo1 {

    public static void main(String[] args) {
        String test = "abcdae";
        Integer result = getLongSubStr(test);
        System.out.println(result);
    }

    private static Integer getLongSubStr(String str){
        Map<Character, Integer> map = new HashMap<>();
        int i = -1, result = 0;
        for(int j = 0; j < str.length(); j++){
            Character c = str.charAt(j);
            //如果包含该char，则移动i下标到上次该char的标记位置，例如i=1
            if(map.containsKey(c)){
                i = Math.max(i, map.get(c));
            }
            //更新该char在map中的v，即下标位置+1
            map.put(c, j);
            //j-i即为本次遇到重复char时最大的长度，如j=5时，char=a, result = 5-1
            result = Math.max(result, j-i);
        }
        return result;
    }
}
