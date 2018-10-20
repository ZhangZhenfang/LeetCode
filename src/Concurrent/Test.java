package Concurrent;

import java.util.concurrent.ConcurrentHashMap;

public class Test {

    public static void main(String[] args){

        TT tt = new TT();
//        System.out.println(tt.test);
//

    }
    public static void change(T s){
        System.out.println(s);
        s = new T(3);
        System.out.println(s);
    }

}

class T{
    public int t;
    private int test = 9;
    public T(){

    }
    public T(int t){
        this.t = t;
    }
}
class TT extends T{

}