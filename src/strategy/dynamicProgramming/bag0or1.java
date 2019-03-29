package strategy.dynamicProgramming;

/**
 * @Description  动态规划处理0-1问题
 * @Author liuqn
 * @Date 2019/3/29 15:50
 * @Version
 **/
public class bag0or1 {
   // weight: 物品重量，n: 物品个数，w: 背包可承载重量
    public int knapsack(int[] weight, int n, int w) {
        boolean[] states = new boolean[w+1]; // 默认值 false
        states[0] = true;  // 第一行的数据要特殊处理，可以利用哨兵优化
        states[weight[0]] = true;
        for (int i = 1; i < n; ++i) { // 动态规划状态转移
           /* for (int j = 0; j <= w; ++j) {// 不把第 i 个物品放入背包
                //不放入，就是在上一层的基础上什么也没做，直接copy到这一层
                if (states[i-1][j] == true) {
                    states[i][j] = states[i-1][j];
                }
            }*/
            //w-weight[i] 保证添加了之后不能超过w
            for (int j = 0; j <= w-weight[i]; ++j) {// 把第 i 个物品放入背包
                if (states[j]==true){//在上层每个总重量上+本次物品的重量
                    states[j+weight[i]] = true;
                }
            }
        }
        for (int i = w; i >= 0; --i) { // 输出结果
            if (states[i] == true) return i;
        }
        return 0;
    }

    public static void main(String[] args) {
        bag0or1 bag0or1 =new bag0or1();
        System.out.println(bag0or1.knapsack(new int[]{2, 2, 4,6, 3}, 5, 9));

    }
}
