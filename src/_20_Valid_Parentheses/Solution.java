package _20_Valid_Parentheses;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ZhangZhenfang
 * @date 2018/10/20 15:00
 *
 */
public class Solution {

    public static void main(String[] args){
        System.out.println(new Solution().isValid("((("));
    }
    public boolean isValid(String s){

        if(s.length() == 0){
            return true;
        }
        if(s.length() < 2){
            return false;
        }
        char[] chars = new char[s.length() + 1];
        Map<Character, Integer> map = new HashMap<>();
        map.put('(', 1);
        map.put(')', -1);
        map.put('[', 2);
        map.put(']', -2);
        map.put('{', 3);
        map.put('}', -3);
        map.put(' ', 4);
        int top = 0;
        int index = 0;
        chars[top++] = ' ';
        while(index < s.length()){
            if(map.get(s.charAt(index)) > 0){
                chars[top++] = s.charAt(index++);
            }
            else{
                if(map.get(s.charAt(index)) + map.get(chars[top - 1]) == 0){
                    index++;
                    top--;
                }
                else{
                    return false;
                }
            }
        }
        if(top == 1){
            return true;
        }
        else{
            return false;
        }
    }
}
