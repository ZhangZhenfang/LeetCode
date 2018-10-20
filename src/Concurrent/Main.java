package Concurrent;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

public class Main {
    public static int a;
    public static void main(String[] args){
        List queue = new ArrayList<Integer>();
        A a = new A(queue);
        B b = new B(queue, 10);

        Thread t1 = new Thread(a);
        Thread t2 = new Thread(b);
        t1.start();
        t2.start();
//        HashSet
    }
}

class A implements Runnable{

    private final List<Integer> queue;

    public A(List<Integer> queue){
        this.queue = queue;
    }

    @Override
    public void run() {
        while(true){
            synchronized (queue){
                if(queue.size() == 0){
                    System.out.println("消费者等待");
                    try{
                        queue.wait();
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
                else{
                    System.out.println(queue.get(0));
                    queue.remove(0);
                }
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}

class B implements Runnable{

    private final List<Integer> queue;
    private final int length;
    public B(List<Integer> queue, int length){
        this.queue = queue;
        this.length = length;
    }

    @Override
    public void run() {
        while(true){
            synchronized (queue){

                if(queue.size() == length || queue.size() == 0){
                    try {
                        System.out.println("生产者等待");
//                        queue.notifyAll();
                        if(queue.size() == 0){
                            queue.notifyAll();
                        }
                        else
                            queue.wait();

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
                else{
                    Random r = new Random();
                    queue.add(r.nextInt());
                }
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}