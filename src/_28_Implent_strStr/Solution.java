package _28_Implent_strStr;

/**
 * @author ZhangZhenfang
 * @date 2018/11/25 14:50
 */
public class Solution {

    public static void main(String[] args) {
        String str = "hello";
        long start = System.nanoTime();
        System.out.println(new Solution().strStr(str, "lo"));
        System.out.println(System.nanoTime() - start);
    }

    public int strStr(String haystack, String needle) {
        if (needle.length() > haystack.length()) {
            return -1;
        }
        if (needle.length() == 0) {
            return 0;
        }
        int max = haystack.length() - needle.length();
        for (int i = 0; i <= max; ) {
            while(i <= max && haystack.charAt(i++) != needle.charAt(0));
            int j = i - 1;
            for (int k = 0; k < needle.length(); k++, j++) {
                if (needle.charAt(k) != haystack.charAt(j)) {
                    break;
                }
            }
            if (j - i + 1 == needle.length()) {
                return i - 1;
            }
        }
        return -1;
    }
}
