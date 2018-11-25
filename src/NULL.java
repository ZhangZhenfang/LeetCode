/**
 * @author ZhangZhenfang
 * @date 2018/10/21 11:38
 */

public class NULL {

    public static void print(){
        boolean result=false?false:true==false?true:false;
        System.out.println(""+result+"");
        System.out.println("AAAAAA");
    }
    public static void main(String[] args) {
        try{
            ((NULL)null).print();

        }catch(NullPointerException e){
            System.out.println("NullPointerException");
        }
    }
}
interface a{
    void fun();
}