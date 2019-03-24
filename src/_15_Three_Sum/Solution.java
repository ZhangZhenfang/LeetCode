package _15_Three_Sum;

import java.util.*;

/**
 * Given an array nums of n integers and an integer target, find three integers in nums such that the sum is closest to
 * target. Return the sum of the three integers. You may assume that each input would have exactly one solution.
 *
 * Example:
 *
 * Given array nums = [-1, 2, 1, -4], and target = 1.
 *
 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 */

/**
 * @author ZhangZhenfang
 * @date 2019/3/24 10:46
 */
public class Solution {

    public static void main(String[] args) {
        int[] nums = new int[]{-1,0,1,2,-1,-4};
        List<List<Integer>> lists = new Solution().threeSum(nums);
        lists.forEach(l -> System.out.println(l));
    }

    public List<List<Integer>> threeSum(int[] nums) {
        // 首先进行排序
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList();
        Set<String> res = new HashSet<>();
        // 选三个数中的一个数
        for (int i = 0; i < nums.length; i++) {
            int sum = -nums[i];
            // 选三个数中的另外两个数，因为数组已经有序，所以找起来可以用二分查找，这里是用的左右指针
            for (int p = i + 1, q = nums.length - 1; p < q; ) {
                if (nums[p] + nums[q] < sum) {
                    p++;
                } else if (nums[p] + nums[q] > sum) {
                    q--;
                } else { // 如果三个数相加等于0，按照从小到大的顺序组合成字符串插入set里判断是否是重复的组合，如果不是就加到结果集里
                    if (res.add("" + -sum + nums[p] + nums[q])) {
                        result.add(Arrays.asList(new Integer[]{-sum, nums[p], nums[q]}));
                    }
                    p++;
                    q--;
                }
            }
        }
        return result;
    }
}
