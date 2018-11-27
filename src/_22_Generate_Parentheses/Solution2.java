package _22_Generate_Parentheses;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author ZhangZhenfang
 * @date 2018/11/27 11:30
 */
public class Solution2 {

    public static void main(String[] args) {
        System.out.println(new Solution2().generateParenthesis(3));
    }
    /**
     * 1.最终结果左括号数等于右括号数。
     * 2.在任意位置，左括号的个数大于等于右括号。
     * 此方法耗时较长，有很多重复的，虽然用set可以去掉重复的，但是还是浪费时间去计算了。
     * @param n
     * @return
     */
    public List<String> generateParenthesis(int n) {
        Set<String> set = new HashSet<>();
        set.add("");
        return new ArrayList<>(generate(set, n));
    }
    public static Set<String> generate(Set<String> list, int n) {
        if (n <= 0) {
            return list;
        }
        Set<String> res = new HashSet<>();
        int index;
        StringBuilder sb;
        for (String str : list) {
            index = -1;
            do {
                index = str.indexOf("(", index + 1);
                if (index != -1) {
                    res.add(new StringBuilder(str.substring(0, index + 1)).append("()").append(str.substring(index + 1
                            , str.length())).toString());
                }
            } while (index != -1);
            res.add("()" + str);
        }
        return generate(res, n - 1);
    }
}
