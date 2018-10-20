package _11_Container_With_Most_Water;

/**
 * @author ZhangZhenfang
 * @date 2018/10/19 00:06
 * https://leetcode.com/problems/container-with-most-water/
 * 11 Container With Most Water
 */
public class Solution {

    public static void main(String[] args){
        System.out.println(new Solution().maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
    }

    public int maxArea(int[] height) {

        int start = 0, end = height.length - 1;

        int max = 0;

        while(start < end){
            int min;
            if(height[start] > height[end]){
                min = height[end];
                end--;
            }
            else{
                min = height[start];
                start++;
            }
            int water = min * (end - start + 1);
            if(water > max){
                max = water;
            }
        }
        return max;
    }
}
