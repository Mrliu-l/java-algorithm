package org.self.algorithm.huawei;

import java.util.Scanner;

/**
 * 题目描述：识别有效的IP地址和掩码并进行分类统计
 *      https://www.nowcoder.com/practice/de538edd6f7e4bc3a5689723a7435682?tpId=37&tqId=21240&rp=1&ru=%2Fta%2Fhuawei&qru=%2Fta%2Fhuawei%2Fquestion-ranking&tab=answerKey
 *      所有的IP地址划分为 A,B,C,D,E五类
 *           A类地址1.0.0.0~126.255.255.255;
 *           B类地址128.0.0.0~191.255.255.255;
 *           C类地址192.0.0.0~223.255.255.255;
 *           D类地址224.0.0.0~239.255.255.255；
 *           E类地址240.0.0.0~255.255.255.255
 *      私网IP范围是：
 *           10.0.0.0～10.255.255.255
 *           172.16.0.0～172.31.255.255
 *           192.168.0.0～192.168.255.255
 * 输入：
 *      10.70.44.68~255.254.255.0
 *      1.0.0.1~255.0.0.0
 *      192.168.0.2~255.255.255.0
 *      19..0.~255.255.255.0
 * 输出：1 0 1 0 0 2 1
 */
public class Demo9 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a=0,b=0,c=0,d=0,e=0,error = 0,pri=0;
        while (sc.hasNextLine()){
            String line = sc.nextLine();
            String[] split = line.split("~");
            //类似于【0.*.*.*】和【127.*.*.*】的IP
            String s0 = split[0];
            String[] str0s = s0.split("\\.");
            String s00 = str0s[0];
            String s01 = str0s[1];
            //校验子网掩码
            if(!checkIp(str0s) || !checkStr(split[1])){
                error++;
                continue;
            }
            if("0".equals(s00) || "127".equals(s00)){
                continue;
            }
            //ip相关处理
            int num = Integer.valueOf(s00);
            if(num == 10
                    || (num == 172 && (Integer.valueOf(s01) >= 16 && Integer.valueOf(s01) <= 31))
                    || (num == 192 && (Integer.valueOf(s01) == 168))){
                pri++;
            }
            if(num >= 1 && num <= 126) a++;
            if(num >= 128 && num <= 191) b++;
            if(num >= 192 && num <= 223) c++;
            if(num >= 224 && num <= 239) d++;
            if(num >= 240 && num <= 255) e++;
        }
        System.out.println(a + " " + b + " " + c + " " + d + " " + e + " " + error + " " + pri);
    }

    private static Boolean checkIp(String[] split){
        if(split.length != 4) return false;
        for (String num : split) {
            if("".equals(num) || Integer.valueOf(num) < 0 || Integer.valueOf(num) > 255){
                return false;
            }
        }
        return true;
    }

    /**
     * 校验子网掩码
     * @param s 子网掩码
     */
    private static Boolean checkStr(String s) {
        String[] split = s.split("\\.");
        StringBuilder result = new StringBuilder();
        for (String str : split) {
            String s1 = Integer.toBinaryString(Integer.valueOf(str));
            if(!"0".equals(s1) && s1.length() != 8){
                return false;
            }
            result.append(s1);
        }
        boolean matches = result.toString().matches("^[1]+[0]+$");
        if(!matches){
            return false;
        }
        return true;
    }
}
