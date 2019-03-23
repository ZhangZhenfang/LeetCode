/**
 * @author ZhangZhenfang
 * @date 2018/11/3 10:47
 */
public class A {
    public static void main(String[] args) {
    }

    public int A(){
        return 1;
    }

    public A(){
        System.out.println(A());
    }
    static class Inner {
        public void method() {
            System.out.println("met");
        }
    }
    class Node<K extends Comparable> {
        K k;
        Node n = (Node<K>)new Object();
    }
}
