package org.self.algorithm.huawei;

import java.util.Scanner;

/**
 * 题目描述：
 *      坐标移动:开发一个坐标计算工具， A表示向左移动，D表示向右移动，W表示向上移动，S表示向下移动。从（0,0）点开始移动，从输入字符串里面读取一些坐标，并将最终输入结果输出到输出文件里面。
 *      https://www.nowcoder.com/practice/119bcca3befb405fbe58abe9c532eb29?tpId=37&tqId=21240&rp=1&ru=%2Fta%2Fhuawei&qru=%2Fta%2Fhuawei%2Fquestion-ranking&tab=answerKey
 * 输入：A10;S20;W10;D30;X;A1A;B10A11;;A10;
 * 输出：10,-10
 */
public class Demo8 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()){
            String[] strArray = sc.nextLine().split(";");
            int x = 0, y = 0;
            for (String str : strArray) {
                if(str.length() > 3 || str.length() <= 1){
                    continue;
                }
                boolean valid = true;
                int v = 0;
                for(int i = 1; i < str.length(); i++){
                    int t = str.charAt(i) - '0';
                    if(t < 0 || t >= 10){
                        valid = false;
                        break;
                    }
                    if(i == 1 && str.length() == 3){
                        v = t * 10;
                    }else{
                        v += t;
                    }
                }
                if(!valid){
                    continue;
                }
                switch (str.charAt(0)){
                    case 'A':
                        x -= v;
                        break;
                    case 'D':
                        x += v;
                        break;
                    case 'W':
                        y += v;
                        break;
                    case 'S':
                        y -= v;
                        break;
                    default:
                        break;
                }
            }
            System.out.println(x + "," + y);
        }
    }
}
