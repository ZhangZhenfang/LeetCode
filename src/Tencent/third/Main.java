package Tencent.third;

import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        int t = in.nextInt();

        while(t > 0){
            int A = in.nextInt();
            int B = in.nextInt();
            int C = in.nextInt();
            int i = 0;
            //只需检查i <= B个A的和，i > B个A的结果和i- B相同
            for(; i < B; i++){
                if((A * i + C) % B == 0){
                    System.out.println("YES");
                    break;
                }
            }
            if(i == B){
                System.out.println("NO");
            }
            t--;
        }
    }
}
