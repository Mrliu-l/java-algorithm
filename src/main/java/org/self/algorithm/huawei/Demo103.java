package org.self.algorithm.huawei;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

//题目描述
//        Redraiment是走梅花桩的高手。Redraiment可以选择任意一个起点，从前到后，但只能从低处往高处的桩子走。他希望走的步数最多，你能替Redraiment研究他最多走的步数吗？
//    输入
//        6
//        2 5 1 5 4 5
//    输出
//        3
public class Demo103 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while ((str = reader.readLine()) != null){
            int num = Integer.valueOf(str);
            int[] array = new int[num];
            String[] strArray = reader.readLine().split(" ");
            for (int i = 0; i < strArray.length; i++) {
                array[i] = Integer.valueOf(strArray[i]);
            }
            int[] result = new int[num];
            Arrays.fill(result, 1);
            for(int i = 0; i < num; i++){
                for(int j = 0; j < i; j++){
                    if(array[j] < array[i]){
                        result[i] = Math.max(result[i], result[j]+1);
                    }
                }
            }
            //选择出最值
            int max=1;
            for (int i = 0; i <result.length ; i++) {
                max=Math.max(result[i],max);
            }
            System.out.println(max);
        }
    }
}
