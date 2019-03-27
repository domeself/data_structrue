package sort;

import java.util.Arrays;

/**
 * @Description
 * @Author liuqn
 * @Date 2019/3/13 9:32
 * @Version
 **/
public class SelectionSort {
    public static void main(String[] args) {
        int[] array = new int[]{3,5,1,9,6,8};
        selectSort(array);
        Arrays.stream(array).forEach(System.out::println);


    }

    private static void selectSort(int[] oriArray){

        for (int i = 0; i < oriArray.length-1; i++) {
            for (int j = i; j <oriArray.length-1 ; j++) {
                if(oriArray[j]<oriArray[j+1]){
                    oriArray[j]=oriArray[j]^oriArray[j+1];
                    oriArray[j+1]=oriArray[j]^oriArray[j+1];
                    oriArray[j]=oriArray[j]^oriArray[j+1];
                }
            }
            oriArray[i]=oriArray[i]^oriArray[oriArray.length-1];
            oriArray[oriArray.length-1]=oriArray[i]^oriArray[oriArray.length-1];
            oriArray[i]=oriArray[i]^oriArray[oriArray.length-1];

        }
    }

}
