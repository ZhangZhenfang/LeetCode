package shunfeng.first;

import java.util.Scanner;

/**
 * 顺丰笔试第一题双节棍字符串
 * ac
 * @author ZhangZhenfang
 *
 */
public class Main {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        String str = in.nextLine();

        if(str.length() < 5){
            System.out.println("NULL");
            return ;
        }

        int a = 0, b = 0, c = 0, d = 0;
        int maxIndex = 0;
        int maxLength = 0;
        while(d < str.length() - 1){
            a = b;
            b = c;
            c = d;

            for(; d < str.length() - 1; ){
                if(str.charAt(d) != str.charAt(++d)){
                    break;
                }
            }
            int ta = a, td = d;
            if((b - a) > (d - c)){
                ta = b - d + c;
            }
            else if((b - a) > (d - c)){
                td = d - (b - a -d + c);
            }
            if((td - c) == (b - ta) && (c - b) < (d - c)){
                if(maxLength < d - ta){
                    maxIndex = ta;
                    maxLength = td - ta;
                }
            }
        }
        if(maxLength == 0){
            System.out.println("NULL");
        }
        else{
            System.out.println(str.substring(maxIndex, maxIndex + maxLength));
        }
    }
}
