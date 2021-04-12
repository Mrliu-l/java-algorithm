package org.self.algorithm.real;

public class Demo4 {

    public static void main(String[] args) {
        int sum = 0;
    }

    /**
     *      1
     *   1   2
     * 1  2
     *
     * 111 + 112 + 12
     */
    private int sumTreeNode(TreeNode treeNode,int num){
        if(treeNode == null){
            return 0;
        }
        num = num * 10 + treeNode.value;
        if(treeNode.left == null && treeNode.right == null){
            return num;
        }
        return sumTreeNode(treeNode.left, num) + sumTreeNode(treeNode.right, num);
    }



    public class TreeNode{
        public TreeNode(int value) {
            this.value = value;
        }

        private int value;
        private TreeNode left;
        private TreeNode right;
    }
}
