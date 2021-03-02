package org.self.algorithm.huawei;

import java.util.Scanner;

/**
 * 题目描述：
 *      输入一个整数，将这个整数以字符串的形式逆序输出
 *      程序不考虑负数的情况，若数字含有0，则逆序形式也含有0，如输入为100，则输出为001
 */
public class Demo6 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String str = sc.nextLine();
            String[] splitStr = str.split("\\s+");
            StringBuilder sb = new StringBuilder();
            int length = splitStr.length;
            for(; length > 0; length--){
                sb.append(splitStr[length-1]).append(" ");
            }
            System.out.println(sb.toString());
        }
    }
}
