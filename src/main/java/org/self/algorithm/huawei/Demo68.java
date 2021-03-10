package org.self.algorithm.huawei;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 题目：成绩排序
 * 连接：https://www.nowcoder.com/practice/8e400fd9905747e4acc2aeed7240978b?tpId=37&tqId=21291&rp=1&ru=%2Fta%2Fhuawei&qru=%2Fta%2Fhuawei%2Fquestion-ranking&tab=answerKey
 */
public class Demo68 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while ((str = br.readLine()) != null){
            int size = Integer.valueOf(str);
            int order = Integer.valueOf(br.readLine());
            List<Target> list = new ArrayList<>(size);
            for(int i = 0; i < size; i++){
                String[] targetArray = br.readLine().split(" ");
                list.add(new Target(targetArray[0], Integer.valueOf(targetArray[1])));
            }
            Collections.sort(list, (o1, o2) -> {
                if(order == 0){
                    return o1.score - o2.score;
                }
                return o2.score - o1.score;
            });
            list.stream().sorted((o1,o2) -> {
                if(order == 1){
                    return o1.score - o2.score;
                }
                return o2.score - o1.score;
            }).forEach(t -> System.out.println(t.name + " " + t.score));
        }
    }

    public static class Target{
        private String name;
        private Integer score;

        public Target(String name, Integer score) {
            this.name = name;
            this.score = score;
        }
    }
}
