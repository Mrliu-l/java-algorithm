package org.self.algorithm.huawei;

import java.util.Scanner;
import java.util.Stack;

/**
 * 题目描述
 * 定义一个二维数组N*M（其中2<=N<=10;2<=M<=10），如5 × 5数组下所示：
 * int maze[5][5] = {
 * 0, 1, 0, 0, 0,
 * 0, 1, 0, 1, 0,
 * 0, 0, 0, 0, 0,
 * 0, 1, 1, 1, 0,
 * 0, 0, 0, 1, 0,
 * };
 * 它表示一个迷宫，其中的1表示墙壁，0表示可以走的路，只能横着走或竖着走，不能斜着走，要求编程序找出从左上角到右下角的最短路线。入口点为[0,0],既第一空格是可以走的路。
 * 本题含有多组数据。
 */
public class Demo43 {

    private int n;
    private int m;
    private int[][] maze;
    private Stack<Pair> paths = new Stack<>();

    public Demo43(int n, int m, int[][] maze) {
        this.n = n;
        this.m = m;
        this.maze = maze;
    }

    public class Pair{
        private int i;
        private int j;

        public Pair(int i, int j) {
            this.i = i;
            this.j = j;
        }
        private void outResult(){
            System.out.println("(" + i + "," + j + ")");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()){
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] maze = new int[n][m];
            for(int i = 0; i < n; i++){
                for(int j = 0; j < m; j++){
                    maze[i][j] = sc.nextInt();
                }
            }
            Demo43 demo43 = new Demo43(n, m, maze);
            demo43.solve(0,0);
            demo43.out();
        }
    }

    private Boolean solve(int i, int j) {
        if(maze[i][j] != 0) return false;
        paths.push(new Pair(i, j));
        if(i == n-1 && j == m-1) return true;
        if(i + 1 < n && solve(i + 1, j)){
            return true;
        }
        if(j + 1 < m && solve(i, j + 1)){
            return true;
        }
        paths.pop();
        return false;
    }

    private void out() {
        for (Pair path : paths) {
            path.outResult();
        }
    }
}
