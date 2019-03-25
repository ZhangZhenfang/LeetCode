package _12_Integer_To_Roman;


import java.util.HashMap;
import java.util.Map;

/**
 * @author ZhangZhenfang
 * @date 2018/10/19 09:27
 * 12 Integer to Roman
 */
public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().intToRoman(13));

    }

    public String intToRoman(int num) {
        int[] array = new int[]{ 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
        Map<Integer, String> map = new HashMap<Integer, String>();
        map.put(1, "I");
        map.put(4, "IV");
        map.put(5, "V");
        map.put(9, "IX");
        map.put(10, "X");
        map.put(40, "XL");
        map.put(50, "L");
        map.put(90, "XC");
        map.put(100, "C");
        map.put(400, "CD");
        map.put(500, "D");
        map.put(900, "CM");
        map.put(1000, "M");

        String res = "";
        for (int i = 0; i < array.length; i++) {
            while (num - array[i] >= 0) {
                num -= array[i];
                res += map.get(array[i]);
            }
        }
        return res;
    }
}
