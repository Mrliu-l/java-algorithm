package org.self.algorithm.huawei;

import java.io.IOException;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * 题目：整形数组合并
 * 连接：https://www.nowcoder.com/practice/c4f11ea2c886429faf91decfaf6a310b?tpId=37&tqId=21303&rp=1&ru=%2Fta%2Fhuawei&qru=%2Fta%2Fhuawei%2Fquestion-ranking&tab=answerKey
 */
public class Demo80 {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()){
            Integer num1 = sc.nextInt();
            Set<Integer> set = new TreeSet<>();
            for(int i = 0; i < num1; i++){
                set.add(sc.nextInt());
            }
            int num2 = sc.nextInt();
            for(int i = 0; i < num2; i++){
                set.add(sc.nextInt());
            }

            for(Integer integer : set){
                System.out.print(integer);
            }
            System.out.println();
        }
    }
}
