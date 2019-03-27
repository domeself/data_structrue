package algorithm;

import java.util.Arrays;

/**
 * @module data_structure
 * @ClassName TwoSum2
 * @Description  求数组中2个元素之和>target有多少对
 * @Author superNove
 * @Date 2019/1/29 0:16
 * @Version 1.0
 */

public class TwoSum2 {
    public int twoSum(int[] arrays,int target){
        Arrays.sort(arrays);
        int left = 0;
        int right = arrays.length-1;
        int ans = 0;
        while(left<right){
            if(arrays[left]+arrays[right]>target){
                ans = ans + (right-left);
                right--;
            }else{
                left++;
            }
        }
        return ans;
    }
}

