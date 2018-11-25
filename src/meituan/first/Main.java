package meituan.first;

import java.util.Scanner;

/**
 * @author ZhangZhenfang
 * @date 2018/10/22 20:01
 */
public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int res = 0;
        int[][] array = new int[n][3];

        for(int i = 0; i < n; i++){
            array[i][0] = in.nextInt();
            array[i][1] = in.nextInt();
            array[i][2] = 1;
        }
        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){
                if(array[i][0] >= array[j][0] && array[i][1] <= array[j][1] && array[j][2] == 1){
                    res++;
                    array[i][2] = 0;
                    break;
                }
            }
        }
        System.out.println(res);
    }
}
