package org.self.algorithm.common;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/*
 题目：跳台阶
 描述：一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
 链接：https://www.nowcoder.com/practice/8c82a5b80378478f9484d87d1c5f12a4?tpId=188&tqId=37521&rp=1&ru=%2Factivity%2Foj&qru=%2Fta%2Fjob-code-high-week%2Fquestion-ranking&tab=answerKey
*/
public class Demo10 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while (null != (str = reader.readLine())){
            int num = Integer.valueOf(str);
            if(num == 1){
                System.out.println(1);
                continue;
            }
            if(num == 2){
                System.out.println(2);
                continue;
            }
            int[] result = new int[num];
            result[0] = 1; result[1] = 2;
            //F(n) = F(n-1) + F(n-2)
            for(int i = 2; i < num; i++){
                result[i] = result[i-1] + result[i-2];
            }
            System.out.println(result[num-1]);
        }
    }
}
