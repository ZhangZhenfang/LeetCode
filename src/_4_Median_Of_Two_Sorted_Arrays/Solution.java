package _4_Median_Of_Two_Sorted_Arrays;

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            int[] t = nums2;
            nums2 = nums1;
            nums1 = t;
        }
        int m = nums1.length;
        int n = nums2.length;
        int start = 0, end = nums1.length;

        int midIndex = (m + n + 1) / 2;
        int i, j;

        while (start <= end) {
            i = (end + start) / 2;
            j = midIndex - i;
            if (i < end && nums1[i] < nums2[j - 1]) {
                start = i + 1;
            } else if (i > start && nums1[i - 1] > nums2[j]) {
                end = i - 1;
            } else {
                int maxLeft = 0;
                if (i == 0) {
                    maxLeft = nums2[j - 1];
                } else if (j == 0) {
                    maxLeft = nums1[i - 1];
                } else {
                    maxLeft = Math.max(nums1[i - 1], nums2[j - 1]);
                }
                if ((m + n) % 2 == 1) {
                    return maxLeft;
                }

                int minRight = 0;
                if (i == m) {
                    minRight = nums2[j];
                } else if (j == n) {
                    minRight = nums1[i] ;
                } else {
                    minRight = Math.min(nums2[j], nums1[i]);
                }
                return (minRight + maxLeft) / 2.0;
            }
        }
        return 0;
    }

}