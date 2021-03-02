package org.self.algorithm.huawei;

import java.util.Scanner;

/**
 * 题目描述：购物车之动态规划解决
 *      https://www.nowcoder.com/practice/f9c6f980eeec43ef85be20755ddbeaf4?tpId=37&tqId=21239&rp=1&ru=%2Fta%2Fhuawei&qru=%2Fta%2Fhuawei%2Fquestion-ranking&tab=answerKey
 */
public class Demo7 {

    private static int dw=10;//题目中说明加个为10的整数倍 -> 加快运行

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            //购买总价格
            int money = sc.nextInt()/dw;
            //产品个数
            int number = sc.nextInt();
            //接收所有的产品信息
            Good[] goods = new Good[number+1];
            //组装商品
            for(int i = 1; i <= number; i++){
                int v = sc.nextInt();
                int p = sc.nextInt();
                int q = sc.nextInt();
                goods[i] = new Good(v/dw, p, q);
                if(q > 0){
                    if(goods[q].good1 == null){
                        goods[q].good1 = goods[i];
                    }else{
                        goods[q].good2 = goods[i];
                    }
                }
            }
            //动态规划：开始
            int[][] dp = new int[number+1][money+1];
            //遍历商品
            for(int i = 1; i <= number; i++){
                int v=0,v1=0,v2=0,v3=0,tempDp=0,tempDp1=0,tempDp2=0,tempDp3=0;
                v = goods[i].v;
                tempDp = v * goods[i].p;
                if(goods[i].good1 != null){
                    v1 = v + goods[i].good1.v;
                    tempDp1 = tempDp + goods[i].good1.v * goods[i].good1.p;
                }
                if(goods[i].good2 != null){
                    v2 = v + goods[i].good2.v;
                    tempDp2 = tempDp + goods[i].good2.v * goods[i].good2.p;
                }
                if(goods[i].good1 != null && goods[i].good2 != null){
                    v3 = v + goods[i].good1.v + goods[i].good2.v;
                    tempDp3 = tempDp + goods[i].good1.v * goods[i].good1.p + goods[i].good2.v * goods[i].good2.p;
                }
                //加个0-max遍历
                for(int j = 1; j <= money; j++){
                    //如果是附件，则不计算
                    if(goods[i].q > 0){
                        dp[i][j] = dp[i-1][j];
                    }else{
                        dp[i][j] = dp[i-1][j];
                        if(j >= v){
                            dp[i][j] = Math.max(dp[i][j], dp[i-1][j-v] + tempDp);
                        }
                        if(j >= v1){
                            dp[i][j] = Math.max(dp[i][j], dp[i-1][j-v1] + tempDp1);
                        }
                        if(j >= v2){
                            dp[i][j] = Math.max(dp[i][j], dp[i-1][j-v2] + tempDp2);
                        }
                        if(j >= v3){
                            dp[i][j] = Math.max(dp[i][j], dp[i-1][j-v3] + tempDp3);
                        }
                    }
                }
            }
            System.out.println(dp[number][money]*dw);
        }
    }

    public static class Good{
        //价格*重要度
        private int v;
        //权重
        private int p;
        //主键还是附件,大于0为附件
        private int q;
        //第一个附件
        private Good good1;
        //第二个附件
        private Good good2;

        public Good(int v, int p, int q) {
            this.v = v;
            this.p = p;
            this.q = q;
        }
    }
}
