package _26_Remove_Duplicates_From_Sorted_Array;

/**
 * @author ZhangZhenfang
 * @date 2018/10/20 19:20
 */
public class Solution {
    public static void main(String[] args){
        System.out.println(new Solution().removeDuplicates(new int[]{1,1,1,2,3,4,5,5,5,6}));
    }

    public int removeDuplicates(int[] nums) {
        int res = 0;
        for(int i = 0; i < nums.length - 1; i++){
            if(nums[i] != nums[i + 1]){
                res++;
            }
        }
        return res + 1;
    }


}
