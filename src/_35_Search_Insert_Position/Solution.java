package _35_Search_Insert_Position;

/**
 * Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
 *
 * You may assume no duplicates in the array.
 *
 * Example 1:
 *
 * Input: [1,3,5,6], 5
 * Output: 2
 * Example 2:
 *
 * Input: [1,3,5,6], 2
 * Output: 1
 * Example 3:
 *
 * Input: [1,3,5,6], 7
 * Output: 4
 * Example 4:
 *
 * Input: [1,3,5,6], 0
 * Output: 0
 */

/**
 * @author ZhangZhenfang
 * @date 2019/3/3 10:37
 */
public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().searchInsert(new int[]{1, 3, 5, 7, 9, 11, 13}, 5));
    }

    public int searchInsert(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        int mid;

        while(start < end) {
            mid = (end - start) / 2;
            if (nums[mid] > target) {
                end = mid;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                return mid;
            }
        }
        System.out.println(start);
        System.out.println(end);
//        System.out.println(mid);
        return 0;
    }

}
