package org.self.algorithm.common;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/*
  题目：找字符串最长不重复子串长度
 */
public class Demo11 {

    //双指针，滑动窗口
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()){
            String str = sc.nextLine();
            int max = 0, i = 0, j = 0;
            Set<Character> set = new HashSet<>();
            while (j < str.length()){
                if(!set.contains(str.charAt(j))){
                    set.add(str.charAt(j++));
                    max = Math.max(max, j - i);
                }else{
                    set.remove(str.charAt(i++));
                }
            }
            System.out.println(max);
        }
    }
}
