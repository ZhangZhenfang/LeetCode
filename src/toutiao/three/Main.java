package toutiao.three;

import java.util.Scanner;

/**
 * @author ZhangZhenfang
 * @date 2019/3/16 11:09
 */
public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            int result = 1;
            int l = in.nextInt();
            int s = in.nextInt();
            int p = s;
            int tmp = 1;
            int q;
            boolean flag = false;
            boolean shift = true;
            int first = 0;
            for (int j = 0; j < l - 1; j++) {
                q = in.nextInt();
                if (p < q) {
                    if (!shift) {
                        tmp = 1;
                        shift = true;
                    }
                    result += ++tmp;
                    System.out.println(tmp);
                } else {
                    if (flag == false) {
                        first = j;
                        flag = true;
                    }
                    if (shift) {
                        tmp = 1;
                        shift = false;
                    }
                    result += ++tmp;
                    System.out.println(tmp);
                }
                p = q;
            }
            q = s;
            if (p < q) {
                result += first;
            }
            System.out.println(result);
        }
    }
}
