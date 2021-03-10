package org.self.algorithm.huawei;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

/**
 * 数据分类处理
 * https://www.nowcoder.com/practice/9a763ed59c7243bd8ab706b2da52b7fd?tpId=37&tqId=21248&rp=1&ru=%2Fta%2Fhuawei&qru=%2Fta%2Fhuawei%2Fquestion-ranking&tab=answerKey
 */
public class Demo25 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while ((str = br.readLine()) != null){
            String[] I = str.split(" ");
            int iNum = Integer.valueOf(I[0]);
            String[] R = br.readLine().split(" ");
            int rNum = Integer.valueOf(R[0]);
            Map<Integer, String> map = new TreeMap<>();
            int sum = 0;
            for(int i = 1; i <= rNum; i++){
                Integer s = Integer.valueOf(R[i]);
                int count = 0;
                if(map.containsKey(s)) continue;
                for(int j = 1; j <= iNum; j++){
                    if(I[j].contains(s.toString())){
                        if(map.get(s) != null){
                            map.put(s, map.get(s) + " " + (j-1) + " " + I[j]);
                        }else{
                            map.put(s, (j-1) + " " + I[j]);
                        }
                        count += 1;
                        sum += 2;
                    }
                }
                if(count > 0){
                    map.put(s, count + " " + map.get(s));
                    sum += 1;
                }
            }
            sum += map.size();
            System.out.print(sum);
            for (Map.Entry<Integer, String> entry : map.entrySet()) {
                System.out.print(" " + entry.getKey() + " " + entry.getValue());
            }
            System.out.println();
        }
    }
}
