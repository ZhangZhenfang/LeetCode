package zhihu.third;

import java.util.Scanner;

/**
 * 忘记题目了，看了很久代码也没印象了，可能时间太紧了，没有添加注释
 * @author ZhangZhenfang
 *
 */

public class Main{

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int m = in.nextInt();

        int[] a = new int[n];
        int[] b = new int[m];

        int[] flag = new int[1000];
        for(int i = 0; i < n; i++){
            flag[in.nextInt()] = 1;
        }
        for(int i = 0; i < m; i++){
            flag[in.nextInt()] = 1;
        }

        int[] result = new int[1000];
        int c = 0;
        for(int i = 0; i < flag.length; i++){
            if(flag[i] == 1){
                result[c++] = i;
            }
        }

        for(int i = 0; i < c; i++){
            if(i < c - 1){
                System.out.print(result[i] + " -> ");
            }
            else{
                System.out.print(result[i]);
            }
        }
    }
}





