package org.self.algorithm.huawei;

import java.io.IOException;
import java.util.Scanner;

/**
 * 题目：
 * 链接：
 */
public class Demo24 {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()){
            int num = sc.nextInt();
            int[] in = new int[num];
            for(int i = 0; i < num; i++){
                in[i] = sc.nextInt();
            }
            int[][] countL = new int[num+1][num+1];
            int[][] countR = new int[num+1][num+1];
            for (int i = 1; i < num; i++){
                int mini = 0;
                for(int j = 0; j < i; j++){
                    if(in[j] < in[i]){
                        if(j == 0){
                            countL[i][j] = 1;
                            mini = j;
                        }else{
                            int c = countL[i][j-1];
                            countL[i][j] = in[j] > in[mini] ? c + 1 : 1;
                            mini = j;
                        }
                    }
                }
            }
            for (int i = 1; i < num; i++){
                if(countL[i][i-1] == 0) continue;
                int mini = i;
                for(int k = i+1; k < num; k++){
                    if(in[k] < in[i]){
                        int c = countR[i][k-1];
                        countR[i][k] = in[k] < in[mini] ? c + 1 : 1;
                        mini = k;
                    }
                }
            }
            int max = 0;
            for(int i = 0; i < countL.length; i++){
                int maxl = 0;
                for(int j = 0; j < countL[0].length; j++) {
                    if (countL[i][j] > maxl) {
                        maxl = countL[i][j];
                    }
                }
                int maxr = 0;
                for(int j = 0; j < countR[0].length; j++) {
                    if (countR[i][j] > maxr) {
                        maxr = countR[i][j];
                    }
                }
                max = (maxl + maxr) > max ? (maxl + maxr) : max;
            }
            System.out.println(num - max - 1);
        }
    }
}