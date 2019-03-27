package sort;

/**
 * @Description
 * @Author liuqn
 * @Date 2019/3/18 14:38
 * @Version 1.0
 **/
public class BinarySort {
    public static void main(String[] args) {

        int[] array = new int[]{2,3,5,7,8,9};
        System.out.println(binarySerch(array, 6));

    }
    public static int binarySerch(int[] array,int target){

       int low = 0;
       int high = array.length;
       while (low<=high){
           int mid = low + ((high-low)>>1);
           int cur = array[mid];
           if(cur>target){
               high = mid -1;
           }else if(cur<target){
               low = mid + 1;
           }else{
               if(mid == 0||array[mid-1]!=target){
                   return mid;
               }else{
                   high = mid - 1;
               }
           }
       }
       return -1;
    }
}
