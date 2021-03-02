package org.self.algorithm.huawei;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * 题目描述：
 *      编写一个函数，计算字符串中含有的不同字符的个数。字符在ACSII码范围内(0~127)，换行表示结束符，不算在字符里。不在范围内的不作统计。多个相同的字符只计算一次
 *      例如，对于字符串abaca而言，有a、b、c三种不同的字符，因此输出3。
 */
public class Demo4 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String result = "";
            String str = sc.nextLine();
            for(int i = 0; i < str.length(); i++){
                String substring = str.substring(i, i+1);
                if(!result.contains(substring)){
                  result = result + substring;
                }
            }
            System.out.println(result.length());
        }
    }

    private static void test1(){
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            Set<Character> set = new HashSet<>();
            String str = sc.nextLine();
            for(int i = 0; i < str.length(); i++){
                set.add(str.charAt(i));
            }
            System.out.println(set.size());
        }
    }
}
