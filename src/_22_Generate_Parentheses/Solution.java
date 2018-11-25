package _22_Generate_Parentheses;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ZhangZhenfang
 * @date 2018/11/25 17:05
 */
public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().generateParenthesis(3));
    }

    /**
     * 1.最终结果左括号数等于右括号数。
     * 2.在任意位置，左括号的个数大于等于右括号。
     * @param n
     * @return
     */
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        generate("", n, n, res);
        return res;
    }

    public static void generate(String str, int left, int right, List<String> res) {
        if (left > right) {
            return ;
        }
        if (left < 0 || right < 0) {
            return ;
        }
        if (left == 0 && right == 0) {
            res.add(str);
        }
        generate(str + "(", left - 1, right, res);
        generate(str + ")", left, right - 1, res);
    }
}
