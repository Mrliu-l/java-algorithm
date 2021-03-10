package org.self.algorithm.huawei;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 题目：密码验证合格程序
 * 连接：https://www.nowcoder.com/practice/184edec193864f0985ad2684fbc86841?tpId=37&tqId=21243&rp=1&ru=%2Fta%2Fhuawei&qru=%2Fta%2Fhuawei%2Fquestion-ranking&tab=answerKey
 */
public class Demo20 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while (null != (str = reader.readLine())){
            if(str.length() < 9){
                System.out.println("NG");
                continue;
            }
            char[] chars = str.toCharArray();
            //判断相同的子串且长度大于2
            if(!check(chars)){
                System.out.println("NG");
                continue;
            }
            int[] count = new int[4];
            //判断包括大小写字母.数字.其它符号,以上四种至少三种
            //元素0-大写，1-小写，2-数字，3-其他
            for(char c : chars){
                if(c >= '0' && c <= '9'){
                    count[2] = 1;
                }else if(c >= 'a' && c <= 'z'){
                    count[1] = 1;
                }else if(c >= 'A' && c <= 'Z'){
                    count[0] = 1;
                }else{
                    count[3] = 1;
                }
            }
            int sum = 0;
            for(int i = 0; i < count.length; i++){
                sum += count[i];
            }
            System.out.println(sum > 2 ? "OK" : "NG");
        }
    }

    public static Boolean check(char[] chars){
        //判断相同的子串且长度大于2
        for(int i = 0; i < chars.length-6; i++){
            for(int j = i+3; j < chars.length-3; j++){
                if(chars[i] == chars[j]){
                    if(chars[i+1] == chars[j+1] && chars[i+2] == chars[j+2]){
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
