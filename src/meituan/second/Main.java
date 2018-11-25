package meituan.second;

import java.util.Scanner;

/**
 * @author ZhangZhenfang
 * @date 2018/10/22 20:37
 */

public class Main{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] a = new int[n];
        for(int i = 0; i < n; i++){
            a[i] = in.nextInt();
        }

        int[] counters = new int[n];

        int ext = 0;
        for(int i = 0; i < n; i++){
            if(a[i] >= n){
                ext++;
                break;
            }
            for(int j = 0; j < a[i]; j++){
                if(i + j >= counters.length){
                    break;
                }
                counters[i + j]++;
            }
            for(int j = 0; j < a[i]; j++){
                if(i - j < 0){
                    break;
                }
                counters[i - j]++;
            }
        }
        int res = 0, t = k - 1 - ext;
        System.out.println(ext);
        for(int i = 0; i < n; i++){
            if(counters[i] >= t){
                res++;
            }
        }
        System.out.println(res);
    }
}