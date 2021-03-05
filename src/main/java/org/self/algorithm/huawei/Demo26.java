package org.self.algorithm.huawei;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 题目描述
 * 编写一个程序，将输入字符串中的字符按如下规则排序。
 * 规则 1 ：英文字母从 A 到 Z 排列，不区分大小写。
 * 如，输入： Type 输出： epTy
 * 规则 2 ：同一个英文字母的大小写同时存在时，按照输入顺序排列。
 * 如，输入： BabA 输出： aABb
 * 规则 3 ：非英文字母的其它字符保持原来的位置。
 * 如，输入： By?e 输出： Be?y
 */
public class Demo26 {

    public static void main(String[] args) throws IOException {
        //由于不知道a/z/A/Z的ASCII值，所以在这里先获取
        int a = 'a', z = 'z', A = 'A', Z = 'Z', num = A - a;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while ((str = bufferedReader.readLine()) != null){
            char[] chars = str.toCharArray();
            char[] orderChars = new char[chars.length];
            int flag = a, j = 0;
            while (flag <= z){
                for (int i = 0; i < chars.length; i++) {
                    char c = chars[i];
                    //特殊字符不处理,这里只处理字符
                    if((c >= a && c <= z) || (c >= A && c <= Z)){
                        if(c == flag || c == flag + num){
                            orderChars[j] = c;
                            j++;
                        }
                    }
                }
                flag++;
            }
            j = 0;
            for(int i = 0; i < chars.length; i++){
                char c = chars[i];
                if((c >= a && c <= z) || (c >= A && c <= Z)){
                    chars[i] = orderChars[j];
                    j++;
                }
            }
            System.out.println(String.valueOf(chars));
        }
    }
}
