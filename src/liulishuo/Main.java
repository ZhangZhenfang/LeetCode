package liulishuo;

import java.util.Scanner;


/**
 * 给你五种零钱的纸币，给定一个金额，写出所有可能的找零个数
 */
public class Main {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int[] money = new int[]{5, 10, 20, 50};

        int m = in.nextInt();
        int[] array = new int[m + 1];
        array[0] = 1;
        for(int i = 0; i < money.length; i++){
            for(int v = money[i]; v <= m; v++){
                array[v] = array[v] + array[v - money[i]];
            }
        }
        for(int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println(array[m]);
    }
}
