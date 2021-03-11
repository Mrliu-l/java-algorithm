package org.self.algorithm.huawei;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
    题目：蛇型矩阵
    描述：
        蛇形矩阵是由1开始的自然数依次排列成的一个矩阵上三角形。
    例如，当输入5时，应该输出的三角形为：
        1 3 6 10 15
        2 5 9 14
        4 8 13
        7 12
        11
    链接：https://www.nowcoder.com/practice/649b210ef44446e3b1cd1be6fa4cab5e?tpId=37&tqId=21258&rp=1&ru=%2Fta%2Fhuawei&qru=%2Fta%2Fhuawei%2Fquestion-ranking&tab=answerKey
*/
public class Demo35 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while (null != (str = reader.readLine())){
            int num = Integer.valueOf(str);
            int[][] result = new int[num+1][num+1];
            for(int i = 1; i <= num; i++){
                result[1][i] = result[1][i-1] + i;
            }
            for(int i = 2; i <= num; i++){
                for(int j = 1; j <= num-i+1; j++){
                    result[i][j] = result[i-1][j+1] - 1;
                }
            }
            for(int i = 0; i < num; i++){
                for(int j = 0; j < num-i; j++){
                    System.out.print(result[i+1][j+1] + " ");
                }
                System.out.println();
            }
        }
    }
}
