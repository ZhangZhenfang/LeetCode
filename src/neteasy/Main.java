package neteasy;

import java.util.Scanner;


/**
 * 网易笔试题
 */
public class Main{
    public static void main(String[] args){
        test3();
    }


    public static void test4(){
        Scanner in = new Scanner(System.in);
    }
    /**
     *
     * 小易有一个古老的游戏机，上面有着经典的游戏俄罗斯方块。因为它比较古老，所以规则和一般的俄罗斯方块不同。
     * 荧幕上一共有 n 列，每次都会有一个 1 x 1 的方块随机落下，在同一列中，后落下的方块会叠在先前的方块之上，当一整行方块都被占满时，这一行会被消去，并得到1分。
     * 有一天，小易又开了一局游戏，当玩到第 m 个方块落下时他觉得太无聊就关掉了，小易希望你告诉他这局游戏他获得的分数。
     *
     * 输入描述:
     * 第一行两个数 n, m
     * 第二行 m 个数，c1, c2, ... , cm ， ci 表示第 i 个方块落在第几列
     * 其中 1 <= n, m <= 1000, 1 <= ci <= n
     *
     * 输出描述:
     * 小易这局游戏获得的分数
     *
     * 输入例子1:
     * 3 9
     * 1 1 2 2 2 3 1 2 3
     *
     * 输出例子1:
     * 2
     *
     */
    public static void test3(){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] c = new int[n];
        for(int i = 0; i < m; i++){
            c[in.nextInt() - 1]++;
        }
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++){
            if(min > c[i]){
                min = c[i];
            }
        }
        System.out.println(min);
    }

    /**
     * 小易觉得高数课太无聊了，决定睡觉。不过他对课上的一些内容挺感兴趣，所以希望你在老师讲到有趣的部分的时候叫醒他一下。你知道了小易对一堂课每分钟知识点的感兴趣程度，并以分数量化，以及他在这堂课上每分钟是否会睡着，你可以叫醒他一次，这会使得他在接下来的k分钟内保持清醒。你需要选择一种方案最大化小易这堂课听到的知识点分值。
     * 输入描述:
     * 第一行 n, k (1 <= n, k <= 105) ，表示这堂课持续多少分钟，以及叫醒小易一次使他能够保持清醒的时间。
     * 第二行 n 个数，a1, a2, ... , an(1 <= ai <= 104) 表示小易对每分钟知识点的感兴趣评分。
     * 第三行 n 个数，t1, t2, ... , tn 表示每分钟小易是否清醒, 1表示清醒。
     *
     * 输出描述:
     * 小易这堂课听到的知识点的最大兴趣值。
     *
     * 输入例子1:
     * 6 3
     * 1 3 5 2 5 4
     * 1 1 0 1 0 0
     *
     * 输出例子1:
     * 16
     */
    public static void test2(){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] a = new int[n];
        int[] t = new int[n];
        for(int i = 0; i < n; i++){
            a[i] = in.nextInt();
        }
        for(int i = 0; i < n; i++){
            t[i] = in.nextInt();
        }
        int score = 0;
        int max = 0;
        int maxIndex = 0;
        int tmp = 0;
        if(k >= n){
            for(int i = 0; i < n; i++){
                score += a[i];
            }
            System.out.println(score);
            return;
        }
        if(k == 0){
            for(int i = 0; i < n; i++){
                if(t[i] == 1){
                    score += a[i];
                }
            }
            System.out.println(score);
            return;
        }
        if(n == 1){
            if(k == 0){
                if(t[0] == 0){
                    System.out.println(0);
                }
                else{
                    System.out.println(a[0]);
                }
                return ;
            }
            else{
                System.out.println(a[0]);
            }
        }
        for(int i = 0; i < n; i++){
            tmp = 0;
            for(int j = 0; j < k && i + j < n; j++){
                if(t[j + i] == 0){
                    tmp += a[j + i];
                }
            }
            if(max < tmp){
                max = tmp;
                maxIndex = i;
            }
        }
        for(int i = 0; i < k && i + maxIndex < n; i++){
            t[i + maxIndex] = 1;
        }
        for(int i = 0; i < n; i++){
            if(t[i] == 1){
                score += a[i];
            }
        }
        System.out.println(score);
    }

    /**
     *
     * 又到了丰收的季节，恰逢小易去牛牛的果园里游玩。
     * 牛牛常说他对整个果园的每个地方都了如指掌，小易不太相信，所以他想考考牛牛。
     * 在果园里有N堆苹果，每堆苹果的数量为ai，小易希望知道从左往右数第x个苹果是属于哪一堆的。
     * 牛牛觉得这个问题太简单，所以希望你来替他回答。
     *
     * 输入描述:
     * 第一行一个数n(1 <= n <= 105)。
     * 第二行n个数ai(1 <= ai <= 1000)，表示从左往右数第i堆有多少苹果
     * 第三行一个数m(1 <= m <= 105)，表示有m次询问。
     * 第四行m个数qi，表示小易希望知道第qi个苹果属于哪一堆。
     *
     * 输出描述:
     * m行，第i行输出第qi个苹果属于哪一堆。
     *
     * 输入例子1:
     * 5
     * 2 7 3 4 9
     * 3
     * 1 25 11
     *
     * 输出例子1:
     * 1
     * 5
     * 3
     */
    public static void test1(){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        a[0] = in.nextInt();
        for(int i = 1; i < n; i++){
            a[i] = a[i - 1] + in.nextInt();
        }
        int m = in.nextInt();
        int[] q = new int[m];
        for(int i = 0; i < m; i++){
            q[i] = in.nextInt();
        }
        in.close();
        if(n == 1){
            for(int j = 0; j < n; j++){
                System.out.println(1);
            }
            return ;
        }
        for(int i = 0; i < m; i++) {
            System.out.println(binarySearch(a, q[i]) + 1);
        }
    }
    public static int binarySearch(int[] arr, int n){
        int start = 0, end = arr.length - 1, mid;
        while(start  < end){
            mid = start + (end - start) / 2;
            if(arr[mid] < n){
                start = mid + 1;
            }
            else if(arr[mid] > n){
                end = mid;
            }
            else{
                return mid;
            }
        }
        return start;
    }
}