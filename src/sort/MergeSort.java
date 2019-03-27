package sort;


import java.util.Arrays;


/**
 * @module data_structure
 * @ClassName MergeSort 归并排序
 * @Description  时间复杂度 O(nlogn)  分治策略
 * @Author superNove
 * @Date 2019/1/30 1:57
 * @Version 1.0
 */

public class MergeSort {
    public static void main(String[] args) {
        int[] array = new int[]{2,5,9,6,3,4,7};
        int[] split = split(array);
        Arrays.stream(split).forEach(System.out::println);
    }

    private static int[] split(int[] array) {
        if (array.length==1){
            return array;
        }
        int mid = 0;
        if(array.length%2==0){
            mid=array.length/2;
        }else{
            mid=(array.length+1)/2;
        }
        int[] arr1=new int[mid];
        int[] arr2=new int[array.length-mid];
        System.arraycopy(array,0,arr1,0,mid);
        System.arraycopy(array,mid,arr2,0,array.length-mid);


            int[] split = split(arr1);


            int[] split2 = split(arr2);

           return merge(split,split2);

    }

    private static int[] merge(int[] split, int[] split2) {
        int[] list = new int[split.length+split2.length];
        int arr0 = 0;
        int arr1 = 0;
        int arr2 = 0;
        while (arr1<split.length&&arr2<split2.length)
        if (split[arr1]<split2[arr2]) {
            list[arr0]=split[arr1];
            arr1++;
            arr0++;
        }
        else if (split[arr1]==split2[arr2]) {
            list[arr0]=split[arr1];
            arr0++;
            list[arr0]=split2[arr2];
            arr0++;
            arr1++;
            arr2++;
        }
        else if (split[arr1]>split2[arr2]) {
            list[arr0]=(split2[arr2]);
            arr2++;
            arr0++;
        }
        for (; arr1 < split.length; arr1++,arr0++) {
            list[arr0]=(split[arr1]);
        }
        for (; arr2 < split2.length; arr2++,arr0++) {
            list[arr0]=(split2[arr2]);
        }


        return list;
    }
}
