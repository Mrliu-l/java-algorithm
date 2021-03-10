package org.self.algorithm.common;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * 滑动窗口：给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值
 * 时间复杂度：O(n)
 */
public class Demo4 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String[] array = sc.nextLine().split(",");
            int[] data = new int[array.length];
            for (int i = 0; i < array.length; i++) {
                data[i] = Integer.valueOf(array[i]);
            }
            int k = Integer.valueOf(sc.nextLine());
            process(data, k);
        }
    }

    private static void process(int[] data, int k){
        LinkedList<Integer> linkedList = new LinkedList<>();
        //未形成窗口
        for(int i = 0; i < k; i++){
            while (!linkedList.isEmpty() && linkedList.peekLast() < data[i]){
                linkedList.removeLast();
            }
            linkedList.add(data[i]);
        }
        System.out.print(linkedList.peekFirst() + ",");
        //形成窗口
        for(int i = k; i < data.length; i++){
            while (!linkedList.isEmpty() && linkedList.peekLast() < data[i]){
                linkedList.removeLast();
            }
            if(!linkedList.isEmpty() && linkedList.peekFirst() == data[i-k]){
                linkedList.removeFirst();
            }
            linkedList.add(data[i]);
            System.out.print(linkedList.peekFirst() + ",");
        }
    }
}
