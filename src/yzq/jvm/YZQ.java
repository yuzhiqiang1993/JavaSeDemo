package yzq.jvm;

public class YZQ {
    public static void main(String[] args) {
//        String name = "yzq";
//        name = "Xeon";
//
//        int[] a = new int[2];
//        System.out.println("name = " + name);
//
//        Thread thread = new Thread();
//
//        thread.start();


        final A a = new A();

        System.out.println("A.a = " + A.a);

    }
}


class A {


    static {
        System.out.println("静态代码块执行了....");
        a=300;
    }

    static int a = 100;


    public A() {
    }
}
