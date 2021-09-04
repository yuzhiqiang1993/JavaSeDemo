package yzq.jmm;

import java.util.concurrent.TimeUnit;

public class TestJMM {

    public static void main(String[] args) {


        JMMDemo jmmDemo = new JMMDemo();
        new Thread(jmmDemo::print, "线程1").start();


        try {
            TimeUnit.MILLISECONDS.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(jmmDemo::changeFlag, "线程2").start();

    }
}

class JMMDemo {
    private volatile boolean flag = true;

    public void print() {

        System.out.println("print 开始执行");
        while (flag) {
        }
        System.out.println("flag的值被更改为了false");
    }


    public void changeFlag() {

        System.out.println("changeFlag 开始执行");
        this.flag = false;

        System.out.println("flag = " + flag);
    }


}

