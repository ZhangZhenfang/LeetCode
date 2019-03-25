package _18_4_Sum;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Given an array nums of n integers and an integer target, are there elements a, b, c, and d in nums such that
 * a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.
 *
 * Note:
 *
 * The solution set must not contain duplicate quadruplets.
 *
 * Example:
 *
 * Given array nums = [1, 0, -1, 0, -2, 2], and target = 0.
 *
 * A solution set is:
 * [
 *   [-1,  0, 0, 1],
 *   [-2, -1, 1, 2],
 *   [-2,  0, 0, 2]
 * ]
 */

/**
 * @author ZhangZhenfang
 * @date 2019/3/25 16:07
 */
public class Solution {
    public static void main(String[] args) {
        int[] nums = new int[]{4, 1, 6, -1, -4, 6, 7, 8, -9, -5, -6};
        List<List<Integer>> lists = new Solution().fourSum(nums, 4);
        lists.forEach(l -> System.out.println(l.toString()));
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int a1 = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                int a2 = nums[j];
                for (int k = j + 1, l = nums.length - 1; k < l; ) {
                    int t = a1 + a2 + nums[k] + nums[l];
                    if (t < target) {
                        k++;
                    } else if (t > target) {
                        l--;
                    } else {
                        result.add(Arrays.asList(new Integer[]{a1, a2, nums[k], nums[l]}));
                        k++;
                        l--;
                    }
                }
            }
        }
        Set<String> filter = new HashSet<>();
        Stream<List<Integer>> listStream = result.stream().filter(l -> filter.add(l.toString()));
        return listStream.collect(Collectors.toList());
    }
}
