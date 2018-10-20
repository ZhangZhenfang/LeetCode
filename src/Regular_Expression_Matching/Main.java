package Regular_Expression_Matching;

public class Main {

    public static void main(String[] args){
        Solution s = new Solution();
        String str = "aaa";
        String p = "ab*a*c*a";
        System.out.println(s.isMatch(str, p));
    }
}

class Solution {
    public boolean isMatch(String s, String p) {

        int i = 0, j = 0;
        for(; i < p.length() && j < s.length();){
            if(p.charAt(i) == '.'){
                if(i < p.length() - 1 && p.charAt(i + 1) == '*'){
                    while(j < s.length())
                        j++;
                    i++;
                }
                else{
                    j++;
                }
                i++;
            }
            else if(Character.isLowerCase(p.charAt(i)) || Character.isUpperCase(p.charAt(i))){
                if(i < p.length() - 1 && p.charAt(i + 1) == '*'){
                    while(j < s.length() && s.charAt(j) == p.charAt(i))
                        j++;
                    i += 2;
                }
                else{
                    if(p.charAt(i) != s.charAt(j)){
                        return false;
                    }
                    i++;
                    j++;
                }
            }
        }
        if(i == p.length() && s.length() == j)return true;
        else{
            if(i > 0 && p.charAt(i - 1) == '*' && j == s.length()){
                char c = p.charAt(i - 2);
                for(int k = i; k < p.length(); k++){
                    if(p.charAt(k) != c){
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }
}