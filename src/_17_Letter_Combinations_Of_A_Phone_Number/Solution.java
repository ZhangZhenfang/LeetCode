package _17_Letter_Combinations_Of_A_Phone_Number;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.
 *
 * A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
 *
 * Example:
 *
 * Input: "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 */

/**
 * @author ZhangZhenfang
 * @date 2018/10/20 19:10
 *
 */
public class Solution {
    public static void main(String[] args) {
        new Solution().letterCombinations("12");
    }
    public List<String> letterCombinations(String digits) {
        List<Character>[] numbers = new ArrayList[9];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = new ArrayList<>();
        }
        numbers[1].add('a'); numbers[1].add('b'); numbers[1].add('c'); numbers[2].add('d'); numbers[2].add('e');
        numbers[2].add('f'); numbers[3].add('g'); numbers[3].add('h'); numbers[3].add('i'); numbers[4].add('j');
        numbers[4].add('k'); numbers[4].add('l'); numbers[5].add('m'); numbers[5].add('n'); numbers[5].add('o');
        numbers[6].add('p'); numbers[6].add('q'); numbers[6].add('r'); numbers[6].add('s'); numbers[7].add('t');
        numbers[7].add('u'); numbers[7].add('v'); numbers[8].add('w'); numbers[8].add('x'); numbers[8].add('y');
        numbers[8].add('z');
        List<String> result = new ArrayList<>();
        f(numbers, 0, digits, new char[digits.length()], result);
        return result;
    }

    public void f(List<Character>[] numbers, int index, String str, char[] chars, List<String> result) {
        if (index >= str.length()) {
            if (index != 0) {
                result.add(new String(chars).trim());
            }
            return ;
        }
        int a = str.charAt(index) - '0' - 1;
        if (a == 0) {
            chars[index] = ' ';
            f(numbers, index + 1, str, chars, result);
        }
        for (int i = 0; i < numbers[a].size(); i++) {
            chars[index] = numbers[a].get(i);
            f(numbers, index + 1, str, chars, result);
        }
    }
}
