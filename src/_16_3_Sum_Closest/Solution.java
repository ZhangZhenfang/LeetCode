package _16_3_Sum_Closest;

import java.util.Arrays;

/**
 * Given an array nums of n integers and an integer target, find three integers in nums such that the sum is closest to target. Return the sum of the three integers. You may assume that each input would have exactly one solution.
 *
 * Example:
 *
 * Given array nums = [-1, 2, 1, -4], and target = 1.
 *
 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 */

/**
 * @author ZhangZhenfang
 * @date 2019/3/25 17:12
 */
public class Solution {
    public static void main(String[] args) {
        int[] nums = new int[]{-1, 2, 1, -4};
        int i = new Solution().threeSumClosest(nums, 1);
        System.out.println(i);
    }

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int result = 0;
        int diff = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int a = nums[i];
            for (int j = i + 1, k = nums.length - 1; j < k; ) {
                int t = a + nums[j] + nums[k] - target;
                if (diff > Math.abs(t)) {
                    diff = Math.abs(t);
                    result = a + nums[j] + nums[k];
                }
                if (t < 0) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        return result;
    }
}
