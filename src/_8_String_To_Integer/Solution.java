package _8_String_To_Integer;

public class Solution {
    public static void main(String[] args){
        Solution s = new Solution();
        System.out.println(s.myAtoi("-91283472332"));
    }

    public int myAtoi(String str){
        int start = 0, end = 0;
        int i = 0;
        while(i < str.length() && str.charAt(i) == ' '){i++;};
        if(i >= str.length()){
            return 0;
        }
        char c = str.charAt(i);
        if(c != '+' && c != '-' && !Character.isDigit(c)){
            return 0;
        }
        for(; i < str.length(); i++){
            char sign;
            c = str.charAt(i);
            if(c == '-' || c == '+' || Character.isDigit(c)){
                if(c == '-'){
                    sign = '-';
                    i++;
                }
                else if(c == '+'){
                    sign = '+';
                    i++;
                }
                else{
                    sign = '+';
                }
                start = i;
                while(i < str.length()){
                    c = str.charAt(i);
                    if(!Character.isDigit(c)){
                        break;
                    }
                    i++;
                }
                end = i;
                String num = str.substring(start, end).trim();
                int p = 0;
                while(p < num.length() && num.charAt(p) == '0'){
                    p++;
                }
                num = num.substring(p, num.length());
                num = sign + "0" + num;
                if(num.length() > 12){
                    return sign == '+' ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                }
                else{
                    long t = Long.parseLong(num);
                    if(t < Integer.MIN_VALUE){
                        return Integer.MIN_VALUE;
                    }
                    if(t > Integer.MAX_VALUE){
                        return Integer.MAX_VALUE;
                    }
                    return (int)t;
                }
            }
        }
        return 0;
    }

}

