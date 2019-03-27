package sort;

import java.util.Arrays;

/**
 * @module data_structure
 * @ClassName InsertSort 插入排序
 * @Description   从第二个元素（K）开始，和前面的元素逆序比较（先找坑），直到找到比K小的元素（坑），再将数据填入坑中,时间复杂度O(n^2)
 * @Author superNove
 * @Date 2019/1/30 0:59
 * @Version 1.0
 */

public class InsertSort {
    public static void main(String[] args) {
        int[] array= new int[]{3,5,1,6,7};
        insertSort(array);
        Arrays.stream(array).forEach(System.out::println);

    }
    public static void insertSort(int[] array){
        if(array.length<=1){
            return;
        }
        for (int i = 1; i <array.length ; i++) {
          int cur = array[i];
          int befor = i-1;
          while (befor>=0){
              if(cur<array[befor]){
                  array[befor+1]=array[befor];
              }else{
                  break;
              }
              befor--;
          }
          array[befor+1]=cur;
        }
    }
}
