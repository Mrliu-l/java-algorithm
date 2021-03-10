package org.self.algorithm.huawei;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 题目：简单密码
 * 连接：https://www.nowcoder.com/practice/7960b5038a2142a18e27e4c733855dac?tpId=37&tqId=21244&rp=1&ru=%2Fta%2Fhuawei&qru=%2Fta%2Fhuawei%2Fquestion-ranking&tab=answerKey
 */
public class Demo21 {

    public static String s1 = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static String s2 = "bcdefghijklmnopqrstuvwxyza";
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while (null != (str = reader.readLine())){
            StringBuilder sb = new StringBuilder();
            str.toCharArray();
            for(int i = 0; i < str.length(); i++){
                char c = str.charAt(i);
                if(c >= 'A' && c <= 'Z'){
                    int index = s1.indexOf(c);
                    sb.append(s2.charAt(index));
                    continue;
                }
                if(c >= 'a' && c <= 'z'){
                    if(c >= 'a' && c <= 'c'){
                        sb.append(2);
                    }else if(c >= 'd' && c <= 'f'){
                        sb.append(3);
                    }else if(c >= 'g' && c <= 'i'){
                        sb.append(4);
                    }else if(c >= 'j' && c <= 'l'){
                        sb.append(5);
                    }else if(c >= 'm' && c <= 'o'){
                        sb.append(6);
                    }else if(c >= 'p' && c <= 's'){
                        sb.append(7);
                    }else if(c >= 't' && c <= 'v'){
                        sb.append(8);
                    }else if(c >= 'w' && c <= 'z'){
                        sb.append(9);
                    }
                    continue;
                }
                sb.append(c);
            }
            System.out.println(sb.toString());
        }
    }
}
