package toutiao.third;

import java.util.Scanner;

/**
 * 头条2019笔试第三批笔试
 * 字符串编码问题
 * ac
 */

public class Main{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[] a = new int[N];

        for(int i = 0; i < N; i++){
            a[i] = in.nextInt() & 0xFF;
//            System.out.println(toBinaryS(a[i]));
        }

        boolean isContinue = false;
        for(int i = 0; i < N; i++){

            String binaryString = toBinaryS(a[i]);
            if(binaryString.startsWith("110")){
                if(1 + i >= N){
                    System.out.println(0);
                    return ;
                }
                for(int j = 0; j < 1; j++){
                    if(!toBinaryS(a[i + 1 + j]).startsWith("10")){
                        System.out.println(0);
                        return ;
                    }
                }
                i += 1;
            }
            else if(binaryString.startsWith("1110")){
                if(2 + i >= N){
                    System.out.println(0);
                    return ;
                }
                for(int j = 0; j < 2; j++){
                    if(!toBinaryS(a[i + 1 + j]).startsWith("10")){
                        System.out.println(0);
                        return ;
                    }
                }
                i += 2;
            }
            else if(binaryString.startsWith("11110")){
                if(3 + i >= N){
                    System.out.println(0);
                    return ;
                }
                for(int j = 0; j < 3; j++){
                    if(!toBinaryS(a[i + 1 + j]).startsWith("10")){
                        System.out.println(0);
                        return ;
                    }
                }
                i += 3;
            }
        }
        System.out.println(1);
    }
    public static String toBinaryS(int n){
        String result = Integer.toBinaryString(n);
        String str = "";
        for(int i = 0; i < 8 - result.length(); i++){
            str += "0";
        }
        return str + result;
    }
}
