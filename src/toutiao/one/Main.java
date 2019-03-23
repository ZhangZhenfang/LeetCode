package toutiao.one;

import java.util.Scanner;

/**
 * @author ZhangZhenfang
 * @date 2019/3/16 10:03
 */
public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        N = 1024 - N;
        int result = 0;
        result += N / 64;
        N %= 64;
        result += N / 16;
        N %= 16;
        result += N / 4;
        N %= 4;
        result += N / 1;
        System.out.println(result);
    }
}
