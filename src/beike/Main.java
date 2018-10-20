package beike;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        int[][] edge = new int[n][n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                edge[i][j] = a[i] > a[j] ? a[i] : a[j];
            }
        }
        for (int i = 0; i < n; i++) {
            edge[i][i] = 100000;
        }
        int[] flag = new int[n];
        flag[0] = 1;
        int min = 100000, minI = 0, minJ = 0;
        int res = 0;
        boolean f = false;
        while (true) {
            min = 100000;
            minI = 0;
            minJ = 0;
            for (int i = 0; i < flag.length; i++) {
                if (flag[i] != 0) {
                    for (int j = 0; j < n; j++) {
                        if (edge[i][j] < min) {
                            min = edge[i][j];
                            minJ = j;
                            minI = i;
                        }
                    }
                }
            }
            edge[minI][minJ] = 100000;
            edge[minJ][minI] = 100000;
            if (flag[minJ] != 1) {
                res += min;
            }
            flag[minJ] = 1;
            for (int i = 0; i < n; i++) {
                if (flag[i] == 0) {
                    f = true;
                }
            }
            if (!f) {
                System.out.println(res);
                return;
            }
            f = false;
        }
    }
}



//    public static void main(String[] args){
//        Scanner in = new Scanner(System.in);
//        String str = in.nextLine();
//        int[] array = new int[20];
//        int[] tmp = new int[14];
//        for(int i = 0; i < 20; i++){
//            array[i] = fun(str.charAt(i));
//            tmp[fun(str.charAt(i))]++;
//        }
//        for(int i = 0; i < array.length; i++){
//            System.out.print(array[i] + " ");
//        }
//        System.out.println();
//        for(int i = 0; i < tmp.length; i++){
//            System.out.print(tmp[i] + " ");
//        }
//        int start = 0, end = 0, length;
//
//        for(int i = 0; i < tmp.length; i++){
//            if(tmp[i] > 0){
//                start = i;
//            }
//        }
//
//
//    }
//    public static int fun(char ch){
//        if(ch == 'A'){
//            return 1;
//        }
//        if(ch == 'T'){
//            return 10;
//        }
//        if(ch == 'J'){
//            return 11;
//        }
//        if(ch == 'Q'){
//            return 12;
//        }
//        if(ch == 'K'){
//            return 13;
//        }
//        return ch - '0';
//    }
//}
