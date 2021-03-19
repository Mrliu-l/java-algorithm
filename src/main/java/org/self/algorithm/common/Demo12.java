package org.self.algorithm.common;

import java.util.Scanner;

public class Demo12 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()){
            String str = sc.nextLine();
            String[] arr = str.split(" ");
            int[] price = new int[arr.length];
            for(int i = 0; i < arr.length; i++){
                int length = arr[i].length();
                Integer num = Integer.valueOf(arr[i].substring(0,length-1));
                if(arr[i].substring(length).equals("Y")){
                    price[i] = num;
                }else{
                    price[i] = num * 7;
                }
            }
            int i = maxProfit(price);
            System.out.println(i);
        }
    }

    public static int maxProfit (int[] prices) {
        // write code here
        int len = prices.length;
        if (len == 0) return 0;
        int[] dpPre = new int[len];
        int[] dpPost = new int[len];
        int min = prices[0], max = prices[len-1];
        for (int i=1;i<len;++i){
            dpPre[i] = Math.max(dpPre[i-1], prices[i]-min);
            min = Math.min(min, prices[i]);
        }

        for (int i=len-2;i>=0;--i){
            dpPost[i] = Math.max(dpPost[i+1], max-prices[i]);
            max = Math.max(max, prices[i]);
        }

        int profit = 0;
        for (int i=0;i<len;++i){
            profit = Math.max(profit, dpPre[i]+(i==len-1 ? 0 : dpPost[i+1]));
        }
        return profit;
    }
}