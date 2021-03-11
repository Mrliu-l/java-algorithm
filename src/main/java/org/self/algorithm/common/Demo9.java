package org.self.algorithm.common;

import java.util.Scanner;

/*
    题目：给定一棵二叉树，判断其是否是自身的镜像（即：是否对称）
    例：给定一棵二叉树，判断琪是否是自身的镜像（即：是否对称）
        例如：下面这棵二叉树是对称的
             1
            /  \
          2    2
         / \    / \
        3 4  4  3
        下面这棵二叉树不对称。
            1
            / \
          2   2
            \    \
            3    3
*/
public class Demo9 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()){
            //构造树
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
            Demo5.Node node = demo5.process(pre, in);
            //check
            Boolean check = check(node.left, node.right);
            System.out.println(check.toString());
        }
    }

    public static Boolean check(Demo5.Node left, Demo5.Node right){
        if((left == null && right != null) || (left != null && right == null))
            return false;
        if(left.value != right.value)
            return false;
        return check(left.left, right.right) && check(left.right, right.left);
    }
}
