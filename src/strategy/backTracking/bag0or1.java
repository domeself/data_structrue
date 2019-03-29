package strategy.backTracking;

/**
 * @Description
 * @Author liuqn
 * @Date 2019/3/29 14:02
 * @Version
 **/
public class bag0or1 {
    // 回溯算法实现。注意：我把输入的变量都定义成了成员变量。
    public int maxW = Integer.MIN_VALUE; // 结果放到 maxW 中
    private int[] weight = {2,3,4};  // 物品重量
    private int n = 3; // 物品个数
    private int w = 6; // 背包承受的最大重量

    public void f(int i, int cw,String trace) { // 调用 f(0, 0)

        System.out.println("i="+i+",cw="+cw);
        if (cw == w || i == n) { // cw==w 表示装满了，i==n 表示物品都考察完了
            if (cw > maxW){
                maxW = cw;
            }
            System.out.println("============end=============="+trace);
            return;
        }
        System.out.println("->");
        f(i+1, cw,trace); // 选择不装第 i 个物品
        System.out.println("<-");
        System.out.println("###########i="+i+",cw="+cw+"########");
        if (cw + weight[i] <= w) {
            System.out.println("-->");
            trace =trace +"->"+ i;
            f(i+1,cw + weight[i],trace); // 选择装第 i 个物品
            System.out.println("<--");
        }
    }

    public static void main(String[] args) {
        bag0or1 bag0or1 = new bag0or1();
        bag0or1.f(0,0,"");
        System.out.println(bag0or1.maxW);

    }

}
