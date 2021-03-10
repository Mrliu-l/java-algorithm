package org.self.algorithm.huawei;

import java.util.Arrays;
import java.util.Scanner;

public class test1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()){
            int num = Integer.valueOf(sc.nextLine());
            int[] t = new int[num];
            String[] arr = sc.nextLine().split(" ");
            int time = Integer.valueOf(arr[arr.length-1]);
            int max = 0;
            for(int i = 0; i < num; i++){
                t[i] = Integer.valueOf(arr[i]);
                if(t[i] > max){
                    max = t[i];
                }
            }

            for (int i = 1; i < max; i++) {
                int time1 = time;
                while (time1 != 0){

                }
            }
        }
    }
}
