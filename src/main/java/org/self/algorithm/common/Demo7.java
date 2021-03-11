package org.self.algorithm.common;

import java.util.Scanner;

/*
    题目：找出链表中的第n个节点
*/
public class Demo7 {


    public static class ListNode {
        int val;
        ListNode next = null;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()){
            String[] arr = sc.nextLine().split(",");
            ListNode node = new ListNode(Integer.valueOf(arr[0]));
            for(int i = 1; i < arr.length; i++){
                node.next = new ListNode(Integer.valueOf(arr[i]));
            }
            int n = Integer.valueOf(sc.nextLine());

            //假设不知道链表长度
            ListNode endNode = node;
            ListNode preNode = node;
            for(int i = 0; i < n; i++){
                endNode = node.next;
            }
            while (endNode.next != null){
                preNode = preNode.next;
            }
            System.out.println(preNode.val);
        }
    }
}
