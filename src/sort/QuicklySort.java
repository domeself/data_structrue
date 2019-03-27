package sort;

import java.util.Arrays;


/**
 * @module data_structure
 * @ClassName QuicklySort  快速排序
 * @Description     将数据分区，先保证 all numbers in right partition > mid number >  all numbers in left partition
 *                  递归处理right partition|left partition
 *                  mid->选择分区中最右的number
 *
 * @Author superNove
 * @Date 2019/1/30 3:02
 * @Version 1.0
 */

public class QuicklySort {
    public static void main(String[] args) {
        int[] array = new int[]{3,5,4,1,8,9,6,7,5};

        quicklySort(array,0,array.length-1);

        Arrays.stream(array).forEach(
                System.out::println
        );
    }

    private static void  quicklySort(int[] array,int begin,int end) {
        if (begin == end) {
            return;
        }
        //记录左边第一个大于midpoint的索引，遍历中发现小于midpoint的number和它交换，然后curIndex++
        int curIndex = begin;

        //默认最右边的number为中点
        int midPoint = array[end];

        for (int i = begin; i <end ; i++) {
            if(array[i]<midPoint){
                //不能用^交换，因为一个数字和自己交换必定为0
             /* array[i]=array[i]^array[curIndex];
                array[curIndex]=array[i]^array[curIndex];
                array[i]=array[i]^array[curIndex];*/
                int temp = array[i];
                array[i]=array[curIndex];
                array[curIndex]=temp;
                curIndex++;
            }
        }
       /* array[end]=array[end]^array[curIndex];
        array[curIndex]=array[end]^array[curIndex];
        array[end]=array[end]^array[curIndex];*/
       //排序结束后，将midpoint插入到数组中（用midpoint和curIndex交换位置）
        int temp = array[end];
        array[end] = array[curIndex];
        array[curIndex] = temp;
        //如果curIndex==begin，说明没有小于midpoint的数，只处理右边
        if(curIndex!=begin){
            quicklySort(array,begin,curIndex-1);
        }
        //如果curIndex==end，说明没有大于midpoint的数，只处理左边
        if(curIndex!=end){
            quicklySort(array,curIndex+1,end);
        }
    }
}
