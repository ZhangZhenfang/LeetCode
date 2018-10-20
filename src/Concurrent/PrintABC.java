package Concurrent;

import java.nio.channels.Pipe;

public class PrintABC {

    public static void main(String[] args){

        Printer p = new Printer();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while(true){
                    p.printChar('A');
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while(true){
                    p.printChar('B');
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while(true){
                    p.printChar('C');
                }
            }
        }).start();
    }
}

class Printer {

    private int singal = 0;

    public void printChar(char c){
        while(true){
            synchronized (this) {
                if (singal == c - 'A') {
                    System.out.println(Thread.currentThread().getName() + " : " + c);

                    singal = (singal + 1) % 3;
                    try {
                        Thread.sleep(1000);
                        this.notifyAll();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    try {
                        this.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}