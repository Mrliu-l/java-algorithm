package org.self.algorithm.huawei;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Demo30 {

    public static void main(String[] args) throws IOException {
        Scanner sc  = new Scanner(System.in);
        while (sc.hasNextLine()){
            String[] strs = sc.nextLine().split(" ");
            //拼接
            String str = strs[0] + strs[1];
            //拆分
            char[] chars = str.toCharArray();
            int n = chars.length % 2;
            char[] char1 = new char[n == 0 ? chars.length/2 : chars.length/2 + 1];
            char[] char2 = new char[chars.length/2];
            int char1num = 0, char2num = 0;
            for(int i = 0; i < chars.length; i++){
                if(i % 2 == 0){
                    char1[char1num] = chars[i];
                    char1num += 1;
                }else{
                    char2[char2num] = chars[i];
                    char2num += 1;
                }
            }
            //排序 & 拼接(按原有下表排序)
            Arrays.sort(char1);
            Arrays.sort(char2);
            char1num = 0; char2num = 0;
            char[] sortChars = new char[chars.length];
            for(int i = 0; i < chars.length; i++){
                if(i % 2 == 0){
                    sortChars[i] = char1[char1num];
                    char1num++;
                }else{
                    sortChars[i] = char2[char2num];
                    char2num++;
                }
            }
            //翻转
            String dict = "0123456789abcdefABCDEF";
            for(int i = 0; i < sortChars.length; i++){
                char c = sortChars[i];
                if(dict.contains(String.valueOf(c))){
                    //转为10进制
                    int b = Integer.parseInt(String.valueOf(c), 16);
                    //转为2进制
                    String s = Integer.toString(b, 2);
                    String format = String.format("%04d", Integer.valueOf(s));
                    String s1 = new StringBuilder(format).reverse().toString();
                    String s2 = Integer.toString(Integer.parseInt(s1, 2), 16).toUpperCase();
                    sortChars[i] = s2.charAt(0);
                }
            }
            System.out.println(String.valueOf(sortChars));
        }
    }
}
