package _3_Longest_Substring_Without_Repeating_Characters;

public class Solution {
    public static void main(String[] args){
        System.out.println(new Solution().lengthOfLongestSubstring("1234567543"));
    }

    public int lengthOfLongestSubstring(String s) {
        int[] maxValue = new int[s.length()];
        if(s.length() == 0){
            return 0;
        }
        maxValue[0] = 1;
        int index = 0;
        int max = 1;
        for(int i = 1; i < maxValue.length; i++){
            int indexof = s.substring(index, i).indexOf(s.charAt(i));
            if(indexof == -1){
                maxValue[i] = (i - index + 1) > maxValue[i - 1] ? i - index + 1 : maxValue[i - 1] + 1;
                if(max < maxValue[i]){
                    max = maxValue[i];
                }
            }
            else{
                index = index + indexof + 1;
                maxValue[i] = 1;
            }
        }
        return max;
    }
}
