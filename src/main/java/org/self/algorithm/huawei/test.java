package org.self.algorithm.huawei;

import java.util.Arrays;
import java.util.Scanner;

public class test {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int L=0,s=0,t=0,n=0;
        while (sc.hasNextLine()){
            L = Integer.valueOf(sc.nextLine());
            String str = sc.nextLine();
            String[] s1 = str.split(" ");
            s = Integer.valueOf(s1[0]);
            t = Integer.valueOf(s1[1]);
            n = Integer.valueOf(s1[2]);
            int[] flag = new int[10000];
            Arrays.fill(flag, 0);
            String s2 = sc.nextLine();
            String[] s3 = s2.split(" ");
            for(int i = 0; i < s3.length; i++){
                int a = Integer.valueOf(s3[i]);
                flag[a] = 1;
            }
            int[] dp = new int[10000];
            Arrays.fill(dp, -1);
            dp[0] = 0;
            for(int i = s; i < L+t-1; i++){
                for(int j = i-t; j <= i-s;j++){
                    if(j>=0&&dp[j]!=-1){
                        if(dp[i]==-1){
                            dp[i]=dp[j]+flag[i];
                        }else if(dp[i]>dp[j]+flag[i]){
                            dp[i] = dp[j]+flag[i];
                        }
                    }
                }
            }
            int res = 10000;
            for(int i =L; i <= L+t-1;i++){
                if(dp[i] != -1 && dp[i]<res){
                    res = dp[i];
                }
            }
            System.out.println(res);
        }
    }
}
