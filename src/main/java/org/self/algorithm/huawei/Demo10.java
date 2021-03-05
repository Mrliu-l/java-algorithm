package org.self.algorithm.huawei;

import java.util.Scanner;

public class Demo10 {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        long number = scanner.nextLong();
        StringBuilder sb = new StringBuilder();
        //Math.sqrt为根号下number， 提高性能
        for(int i = 2; i <= Math.sqrt(number) ;i++){
            while(number != i){
                if(number % i == 0){
                    number /= i;
                    sb.append(i).append(" ");
                }else{
                    break;
                }
            }
        }
        sb.append(number).append(" ");
        System.out.print(sb);
    }
}
