package _27_Remove_Element;

/**
 * @author ZhangZhenfang
 * @date 2018/11/25 14:14
 */
public class Solution {

    public static void main(String[] args) {
        int[] array = new int[]{3, 2, 2, 3, 3, 3, 4, 5};
        int len = new Solution().removeElement(array, 3);
        for (int i = 0; i < len; i++) {
            System.out.print(array[i] + " ");
        }
    }

    public int removeElement(int[] nums, int val) {
        int fast = 0, slow = 0;
        for (fast = 0; fast < nums.length; fast++) {
            if (nums[fast] == val) {
                continue;
            }
            nums[slow++] = nums[fast];
        }
        return slow;
    }
}
