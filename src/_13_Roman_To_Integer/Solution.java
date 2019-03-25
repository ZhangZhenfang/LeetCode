package _13_Roman_To_Integer;


import java.util.HashMap;
import java.util.Map;

/**
 * @author ZhangZhenfang
 * @date 2018/10/19 10:06
 * 13 Roman to Integer
 */
public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().romanToInt("IV"));

    }

    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int res = 1;
        s = s + "I";
        for (int i = s.length() - 2; i >= 0; i--) {
            if (map.get(s.charAt(i)) >= map.get(s.charAt(i + 1))) {
                res += map.get(s.charAt(i));
            } else {
                res -= map.get(s.charAt(i));
            }
        }

        return res - 1;
    }
}
