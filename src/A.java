/**
 * @author ZhangZhenfang
 * @date 2018/11/3 10:47
 */
public class A {
    public static void main(String[] args) {
        A a = new A();
    }

    public int A(){
        return 1;
    }

    public A(){
        System.out.println(A());
    }
}
