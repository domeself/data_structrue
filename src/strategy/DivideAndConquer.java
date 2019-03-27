package strategy;

/**
 * @Description
 * @Author liuqn
 * @Date 2019/3/25 17:17
 * @Version
 **/
public class DivideAndConquer {

    public static void main(String[] args) {
        DivideAndConquer divideAndConquer = new DivideAndConquer();
        int[] array = new int[]{1,5,6,7,4,2};
        System.out.println(divideAndConquer.count(array, 6));
    }
    private int num = 0; // 全局变量或者成员变量

    public int count(int[] a, int n) {
        num = 0;
        mergeSortCounting(a, 0, n-1);
        return num;
    }

    private void mergeSortCounting(int[] a, int p, int r) {

        if (p >= r) {
            System.out.println("mergeSortCounting ##############"+p+"->"+r);
            return;
        }

        int q = (p+r)/2;

        mergeSortCounting(a, p, q);

        mergeSortCounting(a, q+1, r);

        merge(a, p, q+1, r);

    }

    private void merge(int[] a, int p, int q, int r) {

        int temp = q-1;
        while (p<=temp&&q<=r){
            if (a[p]>a[q]){
                num++;
            }
            q++;
            if(q==r+1){
                q=temp;
                p++;
            }
        }

    }

}
