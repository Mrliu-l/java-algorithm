package org.self.algorithm.common;

import java.util.Scanner;

/*
    题目：链表中的节点，每k个一组旋转
    描述：
        将给出的链表中的节点每 k 个一组翻转，返回翻转后的链表
        如果链表中的节点数不是 k 的倍数，将最后剩下的节点保持原样
        你不能更改节点中的值，只能更改节点本身。
        要求空间复杂度 O(1)
        例如：
        给定的链表是1→2→3→4→5
        对于k=2, 你应该返回 2→1→4→3→5
        对于k=3, 你应该返回 3→2→1→4→5
    地址：https://www.nowcoder.com/practice/b49c3dc907814e9bbfa8437c251b028e?tpId=188&tqId=37526&rp=1&ru=%2Factivity%2Foj&qru=%2Fta%2Fjob-code-high-week%2Fquestion-ranking&tab=answerKey
*/
public class Demo6 {


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
            int k = Integer.valueOf(sc.nextLine());

            int pre = 0;
            int end = 0;
            for(int i = pre; i < arr.length - k; i++){
                if(end == arr.length){
                    break;
                }
                while (end - pre < k-1){
                    end++;
                }
            }
            //太难了，不写了
        }
    }
}
