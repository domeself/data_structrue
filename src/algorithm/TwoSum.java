package algorithm;

import java.util.Arrays;

/**
 * @module data_structure
 * @ClassName TwoSum
 * @Description
 * @Author superNove
 * @Date 2019/1/29 0:16
 * @Version 1.0
 */

public class TwoSum {
    public int[] twoSum(int[] arrays,int target){
        int[] origin = new int[arrays.length];
        System.arraycopy(arrays,0,origin,0,origin.length);
        Arrays.sort(arrays);
        int left = 0;
        int right = arrays.length-1;

        while(left<right){
            int sum = arrays[left]+arrays[right];
            if(sum==target){
                return getIndexs(origin,new int[]{arrays[left],arrays[right]});
                
            }else if(sum>right){
                right--;
            }else{
                left++;
            }
        }
        return new int[2];
    }

    private int[] getIndexs(int[] origin, int[] ints) {
        int[] result = new int[2];
        for(int i=0, x=0;i<origin.length&&x<result.length;i++){
            if(origin[i]==ints[0]||origin[i]==ints[1]){
                 result[x++]=i+1;
            }
        }
        return result;
    }

}
