package org.self.algorithm.huawei;

import java.util.Scanner;

/**
 * 题目描述：
 *      输入一个int型整数，按照从右向左的阅读顺序，返回一个不含重复数字的新的整数。保证输入的整数最后一位不是0。
 * 输入：输入一个int型整数
 * 输出：按照从右向左的阅读顺序，返回一个不含重复数字的新的整数
 * 示例：
 *  输入：9876673
 *  输出：37689
 */
public class Demo3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String numberStr = "";
            String str = sc.next();
            int length = str.length();
            for(;length > 0; length--){
                String s = String.valueOf(str.charAt(length - 1));
                if(numberStr.contains(s)){
                    continue;
                }
                numberStr += s;
            }
            System.out.println(Integer.valueOf(numberStr));
        }
    }
}
