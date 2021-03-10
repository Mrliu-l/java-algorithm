package org.self.algorithm.common;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * 滑动窗口：给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值
 * 时间复杂度：O(kn)
 */
public class Demo3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()){
            String[] array = sc.nextLine().split(",");
            int[] data = new int[array.length];
            for(int i = 0; i < array.length; i++){
                data[i] = Integer.valueOf(array[i]);
            }
            int k = Integer.valueOf(sc.nextLine());
            for(int i = 0; i <= data.length - k; i++){
                int max = 0;
                for(int t = i; t < i+k; t++){
                    if(data[t] > max){
                        max = data[t];
                    }
                }
                System.out.println(max+",");
            }
        }
    }
}