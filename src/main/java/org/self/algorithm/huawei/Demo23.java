package org.self.algorithm.huawei;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 题目：实现删除字符串中出现次数最少的字符
 * 链接：https://www.nowcoder.com/practice/05182d328eb848dda7fdd5e029a56da9?tpId=37&tqId=21246&rp=1&ru=%2Fta%2Fhuawei&qru=%2Fta%2Fhuawei%2Fquestion-ranking&tab=answerKey
 */
public class Demo23 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while (null != (str = reader.readLine())){
            int[] countArray = new int['z'+1];
            for(int i = 0; i < str.length(); i++){
                char c = str.charAt(i);
                countArray[c] += 1;
            }
            int min = str.length();
            for(int i = 0; i < countArray.length; i++){
                int count = countArray[i];
                if(count != 0 && count <= min){
                    min = countArray[i];
                }
            }
            StringBuilder outSb = new StringBuilder();
            for(int i = 0; i < countArray.length; i++){
                int count = countArray[i];
                if(count == min){
                    outSb.append((char) i);
                }
            }
            String out = outSb.toString();
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < str.length(); i++){
                if(out.contains(String.valueOf(str.charAt(i)))){
                    continue;
                }
                sb.append(str.charAt(i));
            }
            System.out.println(sb.toString());
        }
    }
}
