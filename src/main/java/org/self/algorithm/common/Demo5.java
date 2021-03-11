package org.self.algorithm.common;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 题目：重建二叉树、前序、中序、倒序输出
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 * 地址：https://www.nowcoder.com/practice/8a19cbe657394eeaac2f6ea9b0f6fcf6?tpId=188&tqId=37520&rp=1&ru=%2Factivity%2Foj&qru=%2Fta%2Fjob-code-high-week%2Fquestion-ranking&tab=answerKey
 */
public class Demo5 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()){
            String[] array = sc.nextLine().split(",");
            int[] pre = new int[array.length];
            for(int i = 0; i < array.length; i++){
                pre[i] = Integer.valueOf(array[i]);
            }

            array = sc.nextLine().split(",");
            int[] in = new int[array.length];
            for(int i = 0; i < array.length; i++){
                in[i] = Integer.valueOf(array[i]);
            }
            Demo5 demo5 = new Demo5();
            Node node = demo5.process(pre, in);
            demo5.preOut(node);
            System.out.println();
            demo5.inOut(node);
            System.out.println();
            demo5.afterOut(node);
        }
    }

    /**
     * 重组二叉树
     * @param pre 前序数组
     * @param in 中序数组
     * @return
     */
    public Node process(int[] pre, int[] in){
        if(pre.length == 0){
            return null;
        }
        Node node = new Node(pre[0]);
        if(pre.length == 1){
            return node;
        }
        int rootIndeOfIn = 0;
        for(int i = 0; i < in.length; i++){
            if(node.value == in[i]){
                rootIndeOfIn = i;
                break;
            }
        }
        node.left = process(Arrays.copyOfRange(pre, 1, rootIndeOfIn+1), Arrays.copyOfRange(in, 0, rootIndeOfIn));
        node.right = process(Arrays.copyOfRange(pre, rootIndeOfIn+1, pre.length), Arrays.copyOfRange(in, rootIndeOfIn, in.length));
        return node;
    }

    public class Node{
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    /**
     * 前序输出
     */
    private void preOut(Node node){
        System.out.print(node.value + ",");
        if (node.left != null){
            preOut(node.left);
        }
        if(node.right != null){
            preOut(node.right);
        }
    }

    /**
     * 中序输出
     */
    private void inOut(Node node){
        if(node == null){
            return;
        }
        inOut(node.left);
        System.out.print(node.value + ",");
        inOut(node.right);
    }

    /**
     * 后序输出
     */
    private void afterOut(Node node){
        if(node == null){
            return;
        }
        afterOut(node.left);
        afterOut(node.right);
        System.out.print(node.value + ",");
    }
}
