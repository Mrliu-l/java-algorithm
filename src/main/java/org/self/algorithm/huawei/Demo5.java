package org.self.algorithm.huawei;

import java.util.Scanner;

/**
 * 题目描述：
 *      输入一个整数，将这个整数以字符串的形式逆序输出
 *      程序不考虑负数的情况，若数字含有0，则逆序形式也含有0，如输入为100，则输出为001
 */
public class Demo5 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String str = sc.next();
            char[] chars = str.toCharArray();
            char[] result = new char[str.length()];
            for(int i = 1; i <= str.length(); i++){
                result[i-1] = chars[str.length() - i];
            }
            System.out.println(new String(result));
        }
    }

//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        while (sc.hasNext()){
//            String str = sc.next();
//            String result = "";
//            int length = str.length();
//            for(; length > 0; length--){
//                result += str.substring(length - 1, length - 0);
//            }
//            System.out.println(result);
//        }
//    }
}
