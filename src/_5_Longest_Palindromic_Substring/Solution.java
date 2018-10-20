package _5_Longest_Palindromic_Substring;

public class Solution {

    public static void main(String[] args){
        System.out.println(new Solution().longestPalindrome("abcdcbaaaaaaa"));
    }

    public String longestPalindrome(String s) {
        int[][] lp = new int[s.length()][s.length()];
        if(s.length() == 0){
            return "";
        }
        lp[0][0] = 1;
        for(int i = 1; i < s.length(); i++){
            lp[i][i] = 1;
            lp[i][i - 1] = 1;
        }
        for(int i = 1; i < lp.length; i++){
            for(int j = 0; j < i; j++){
                if(s.charAt(i) == s.charAt(j) && lp[j + 1][i - 1] == 1){
                    lp[j][i] = 1;
                }
            }
        }

        int max = 0;
        int a = 0, b = 0;
        for(int i = 0; i < lp.length; i++){
            for(int j = i; j < lp[i].length; j++){
                if(lp[i][j] == 1){
                    if(j - i > max){
                        max = j - i;
                        a = i;
                        b = j;
                    }
                }
            }
        }
        return s.substring(a, b + 1);
    }
}
