package Tencent.first;

import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        if(n == 1){
            System.out.println(2);
            return;
        }

        int lcm1 = 1;
        for(int i = lcm1; i < n; i++){
            lcm1 = LCM(lcm1, i + 1, 1);
        }

        int lcm2 = n + 1, step = lcm2;

        while(true){
            lcm2 = LCM(lcm2, step, 1);
            if(lcm2 % lcm1 == 0){
                System.out.println(step);
                break;
            }
            step++;
        }
    }

    public static int LCM(int a, int b, int c){
        int min, max;
        if(a >= b){
            min = b;
            max = a;
        }
        else{
            min = a;
            max = b;
        }
        System.out.println(max + " " + min);
        if(max % min == 0){
            return max;
        }
        if((max * c) % min == 0){
            return max * c;
        }
        for(int i = 2; i < min; i++){
            if((max * i) % min == 0){
                return max * i;
            }
        }
        return min * max;
    }
}
