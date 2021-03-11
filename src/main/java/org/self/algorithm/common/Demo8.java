package org.self.algorithm.common;

import java.util.Scanner;

/*
    题目：判断链表是否有环
*/
public class Demo8 {


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
            ListNode node1 = node.next;
            ListNode node2 = node;
            while (node1.next != null){
                if(node1.next == node2.next){
                    System.out.println("闭环");
                    break;
                }
                node1 = node1.next;
                node2 = node2.next;
            }
            System.out.println("未发生闭环");
        }
    }
}
