package toutiao.two;

import java.util.Scanner;

/**
 * @author ZhangZhenfang
 * @date 2019/3/16 10:49
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        char[] chars = new char[1];
        in.nextLine();
        for (int i = 0; i < n; i++) {
            int index = 0;
            String s = in.nextLine();
            chars = new char[s.length()];
            char[] chars1 = s.toCharArray();
            for (char c : chars1) {
                chars[index++] = c;
                if (index >= 3) {
                    if (chars[index - 3] == chars[index - 2] && chars[index - 2] == chars[index - 1]) {
                        index--;
                    }
                }
                if (index >= 4) {
                    if (chars[index - 4] == chars[index - 3] && chars[index - 2] == chars[index - 1]) {
                        index--;
                    }
                }
            }
            for (int j = 0; j < index; j++) {
                System.out.print(chars[j]);
            }
            System.out.println();
        }
    }
}
