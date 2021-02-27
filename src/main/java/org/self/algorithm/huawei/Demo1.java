package org.self.algorithm.huawei;

import java.util.Scanner;

/**
 * 题目描述：
 *      写出一个程序，接收一个正浮点数值，输出该数值的近似整数值。
 *      如果小数点后数值大于等于5,向上取整；小于5，则向下取整。
 * 输入：输入一个正浮点数值
 * 输出：输出该数值的近似整数值
 * 示例：输入：5.5    输出：6
 */
public class Demo1 {

    public static void main(String[] args) {
        test2();
    }

    private static void test1(){
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextFloat()){
            float number = sc.nextFloat();
            int num = (int) number;
            float num1 = (float) (num + 0.5);
            if(number >= num1){
                System.out.println(num + 1);
            }else{
                System.out.println(num);
            }
        }
    }

    private static void test2(){
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String str = sc.nextLine();
            int index = str.indexOf(".");
            int num = Integer.valueOf(str.substring(0, index));
            if(Integer.valueOf(str.substring(index + 1, index + 2)) >= 5){
                num += 1;
            }
            System.out.println(num);
        }
    }
}
