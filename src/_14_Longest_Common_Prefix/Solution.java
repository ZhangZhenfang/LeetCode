package _14_Longest_Common_Prefix;

/**
 * @author ZhangZhenfang
 * @date 2018/10/19 10:17
 * 14 Longest Common Prefix
 */

public class Solution {

    public static void main(String[] args){
        System.out.println(new Solution().longestCommonPrefix(new String[]{"flower","flow","flight"}));
    }

    public String longestCommonPrefix(String[] strs){
        if(strs.length == 0)
            return "";
        String res = strs[0];
        for(int i = 1; i < strs.length; i++){
            int index = 0;
            while(index < res.length() && index < strs[i].length() && res.charAt(index) == strs[i].charAt(index)){
                index++;
            }
            if(res.length() == 0){
                return res;
            }
            res = res.substring(0, index);
        }
        return res;
    }

}
