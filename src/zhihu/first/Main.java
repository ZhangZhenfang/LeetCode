package zhihu.first;

import java.util.Scanner;

/**
 * 最大连续和
 * ac
 * @author ZhangZhenfang
 *
 */
public class Main {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];

        //动态规划，存储当前下标的最大和
        int[] maxValue = new int[n];
        for(int i = 0; i < n; i++){
            a[i] = in.nextInt();
        }

        //初始化maxValue[0]
        maxValue[0] = a[0];
        for(int i = 1; i < n; i++){
            /**
             * 递推式：
             * f(0) = a[0]
             * f(n) = max{f(n - 1) + a[n], a[n]}
             */
            int t = maxValue[i - 1] + a[i];
            maxValue[i] = t > a[i] ? t : a[i];
        }
        //查找最大的和
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++){
            if(max < maxValue[i]){
                max = maxValue[i];
            }
        }
        System.out.println(max);
    }
}
