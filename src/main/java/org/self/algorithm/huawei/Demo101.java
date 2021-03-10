package org.self.algorithm.huawei;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * 题目：输入整型数组和排序标识，对其元素按照升序或降序进行排序
 * 连接：https://www.nowcoder.com/practice/dd0c6b26c9e541f5b935047ff4156309?tpId=37&tqId=21324&rp=1&ru=%2Fta%2Fhuawei&qru=%2Fta%2Fhuawei%2Fquestion-ranking&tab=answerKey
 */
public class Demo101 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()){
            Integer num = sc.nextInt();
            List<Integer> list = new ArrayList<>();
            for(int i = 0; i < num; i++){
                list.add(sc.nextInt());
            }
            if(1 == sc.nextInt()){
                Collections.sort(list, Collections.reverseOrder());
            }else{
                Collections.sort(list);
            }
            list.forEach(i -> System.out.print(i + " "));
            System.out.println();
        }
    }
}
