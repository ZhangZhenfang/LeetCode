package Concurrent;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class TestProductorAndConsumer {
	
	public static void main(String[] args) {

		Store store = new Store();

		new Thread(new Productor(store)).start();
		new Thread(new Consumer(store)).start();
		new Thread(new Productor(store)).start();
		new Thread(new Consumer(store)).start();
	}

}

class Store{

	private int number = 0;

	public synchronized void produce(){

		while(number >= 1){
			System.out.println("产品已满");
			try{
				this.wait();
			}catch (Exception e){

			}
		}
		System.out.println(Thread.currentThread().getId() + " : " + ++number);
		this.notifyAll();
	}

	public synchronized void consume(){
		while(number <= 0){
			System.out.println("缺货");
			try{
				this.wait();
			}catch (Exception e){

			}
		}
		System.out.println(Thread.currentThread().getId() + " : " + --number);
		this.notifyAll();
	}
}

class Productor implements Runnable{
	private Store store;

	public Productor(Store store){
		this.store = store;
	}
	@Override
	public void run() {
		while(true){
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			store.produce();
		}
	}
}
class Consumer implements Runnable{

	private Store store;

	public Consumer(Store store){
		this.store = store;
	}

	@Override
	public void run() {
		while(true){
			store.consume();
		}
	}
}

