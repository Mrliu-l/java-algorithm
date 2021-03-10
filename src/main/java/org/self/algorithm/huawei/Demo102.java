package org.self.algorithm.huawei;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 输入一个只包含小写英文字母和数字的字符串，按照不同字符统计个数由多到少输出统计结果，如果统计的个数相同，则按照ASCII码由小到大排序输出。
 * 本题含有多组样例输入
 * 输入描述:
 * 一个只包含小写英文字母和数字的字符串。
 *
 输出描述:
 一个字符串，为不同字母出现次数的降序表示。若出现次数相同，则按ASCII码的升序输出。
 示例1
     输入
         aaddccdc
         1b1bbbbbbbbb
     输出
        cda
        b1
 */
public class Demo102 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while((str=br.readLine())!=null){
            char[] chars = str.toCharArray();
            int[] charNums = new int['z' + 1];
            int max = 0;//为排序准备
            for (char c : chars) {
                charNums[c]++;
                if(max < charNums[c]){
                    max = charNums[c];
                }
            }
            StringBuilder sb = new StringBuilder();
            //排序
            for(;max > 0; max--){
                for (int i = 0; i < charNums.length; i++){
                    if(charNums[i] == max){
                        sb.append((char) i);
                    }
                }
            }
            System.out.println(sb.toString());
        }
    }
}
