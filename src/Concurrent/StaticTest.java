package Concurrent;

import java.util.Scanner;

/**
 * @author ZhangZhenfang
 * @date 2018/10/23 10:05
 *
 */

public class StaticTest {
    public static int i = 0;
    public static void main(String[] args) {
        AA a = new AA();
        new Thread(new CC(a)).start();
        new Thread(new BB(a)).start();
        new Thread(new BB(a)).start();
        new Thread(new CC(a)).start();
        new Thread(new BB(a)).start();
        new Thread(new CC(a)).start();
    }
}
class AA{
    public int i = 0;
}

class BB implements Runnable{
    AA s;

    BB(AA s){
        this.s = s;
    }
    @Override
    public void run() {
        s.i++;
        StaticTest.i++;
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class CC implements Runnable{

    AA s;

    CC(AA s){
        this.s = s;
    }
    @Override
    public void run() {
//        System.out.println(s.i);
        System.out.println(StaticTest.i);
    }
}