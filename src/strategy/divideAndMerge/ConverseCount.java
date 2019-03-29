package strategy.divideAndMerge;

/**
 * @Description  求数组的逆序度   1，4，3，5，2   ->  4,3|4,2|3,2|5,2  ==4
 * @Author liuqn
 * @Date 2019/3/25 17:17
 * @Version
 **/
public class ConverseCount {

    public static void main(String[] args) {
        ConverseCount divideAndConquer = new ConverseCount();
        int[] array = new int[]{1,4,3,5,2};
        System.out.println(divideAndConquer.count(array, array.length));
    }
    private int num = 0; // 全局变量或者成员变量

    public int count(int[] a, int n) {

        mergeSortCounting(a, 0, n-1);
        return num;
    }

    private void mergeSortCounting(int[] a, int p, int r) {
        if(p>=r){
            return;
        }
        int devide = (p+r)>>1;
        mergeSortCounting(a,p,devide);
        mergeSortCounting(a,devide+1,r);
        merge(a,p,devide,r);

    }

    private void merge(int[] a, int p, int q, int r) {
        for (int i = p; i <= q; i++) {

            for (int j = q+1; j <=r ; j++) {
                if(a[i]>a[j]){
                    num++;
                }
            }

        }


    }

}
