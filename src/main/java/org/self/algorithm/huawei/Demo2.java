package org.self.algorithm.huawei;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * 题目描述：
 *      数据表记录包含表索引和数值（int范围的正整数），
 *      请对表索引相同的记录进行合并，即将相同索引的数值进行求和运算，输出按照key值升序进行输出。
 * 输入：先输入键值对的个数；然后输入成对的index和value值，以空格隔开
 * 输出：输出合并后的键值对（多行）
 * 示例：
 *  输入：4
 *      0 1
 *      0 2
 *      1 2
 *      3 4
 *  输出：6
 *      0 3
 *      1 2
 *      3 4
 */
public class Demo2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            Map<Integer, Integer> map = new TreeMap<>();
            int sum = sc.nextInt();
            for(int i = 0; i < sum; i++){
                int index = sc.nextInt();
                int value = sc.nextInt();
                if(map.containsKey(index)){
                    map.put(index, map.get(index) + value);
                }else{
                    map.put(index, value);
                }
            }
            for(Map.Entry entry : map.entrySet()){
                System.out.println(entry.getKey() + " " + entry.getValue());
            }
        }
    }
}
