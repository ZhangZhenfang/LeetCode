package _442_Find_All_Duplicates_In_An_Array;

/**
 * @author ZhangZhenfang
 * @date 2019/3/23 22:57
 */

import java.util.ArrayList;
import java.util.List;

/**
 * Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.
 *
 * Find all the elements that appear twice in this array.
 *
 * Could you do it without extra space and in O(n) runtime?
 *
 * Example:
 * Input:
 * [4,3,2,7,8,2,3,1]
 *
 * Output:
 * [2,3]
 */
public class Solution {
    public static void main(String[] args) {
        int[] array = new int[]{9, 3, 2, 5, 6, 9, 3, 1, 4};
        List<Integer> duplicates = new Solution().findDuplicates(array);
        duplicates.forEach(integer -> System.out.println(integer));
    }

    public List<Integer> findDuplicates(int[] nums) {
        List result = new ArrayList();
        /**
         * 因为数组里的值在1-n之间，可以把每个数放在以这个数为下标的位置上，
         * 从前往后扫描数组，判断值和对应位置的值是否相等，不相等则把值放到对应位置，相等则不做处理，继续扫描后面的数，
         * 后面可能会被应该在这个位置的数给换走，如果每一个位置的下标和这个位置的数都相等则没有重复的，
         * 否则一定有一些位置的值和下标不相等。
         */
        int t;
        for (int i = 0; i < nums.length; i++) {
            int index = nums[i] - 1;
            while (nums[i] != nums[index]) {
                t = nums[i];
                nums[i] = nums[index];
                nums[index] = t;
                index = nums[i] - 1;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                result.add(nums[i]);
            }
        }
        return result;
    }
}
