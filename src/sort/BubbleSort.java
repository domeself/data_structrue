package sort;

import java.util.Arrays;

/**
 * @module data_structure
 * @ClassName BubbleSort  冒泡排序
 * @Description  从前到后，相邻两两比较，较大者放后面。一次巡回得出最大值放末尾.时间复杂度O(n^2)
 * @Author superNove
 * @Date 2019/1/30 1:16
 * @Version 1.0
 */

public class BubbleSort {
    public static void main(String[] args) {
        int[] array = new int[]{3,5,1,9,6};
        bubbleSort(array);
        Arrays.stream(array).forEach(System.out::println);
    }

    private static void bubbleSort(int[] array) {
        for (int i = 0; i < array.length-1; i++) {//控制循环次数
            boolean flag = false;
            for (int j = 0; j <array.length-1-i ; j++) {//控制一个巡回内，比较次数
                if (array[j+1]<array[j]){
                    array[j]=array[j]^array[j+1];
                    array[j+1]=array[j+1]^array[j];
                    array[j]=array[j]^array[j+1];
                    flag = true;
                }
            }
            //性能优化、当检测到无交换时说明已经有序，后面的操作省略
            if(!flag){
                break;
            }

        }
    }
}
