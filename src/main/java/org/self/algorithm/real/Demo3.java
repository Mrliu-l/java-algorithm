package org.self.algorithm.real;

public class Demo3 {

    public static void main(String[] args) {

    }

    public Node revertLinkNode(Node node){
        if(node == null || node.next == null){
            return node;
        }
        // 1 2 3 4
        //创建空节点，设置next为node
        Node temp = new Node(0);
        temp.next = node;
        //设置temp做交换使用
        Node temp2 = temp;
        while (node != null && node.next != null){
            temp2.next = node.next;
            node.next = temp2.next.next;
            temp2.next.next = node;
            //重置temp2和node位置  1 2 3 4   2 1 3 4
            temp2 = temp2.next.next;
            node = temp2.next;
        }
        return temp.next;

    }

    public class Node{

        public Node(int value) {
            this.value = value;
        }

        private int value;
        private Node next;
    }
}
