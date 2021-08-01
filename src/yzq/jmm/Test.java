package yzq.jmm;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class Test {
    public static void main(String[] args) {


        FutureTask<String> stringFutureTask = new FutureTask<>(() -> "");

        PrintNum printNum = new PrintNum();

        new Thread(() -> {

            while (printNum.i <= 100) {
                try {
                    printNum.printOuShu();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }, "偶數綫程").start();
        new Thread(() -> {

            while (printNum.i < 100) {
                try {
                    printNum.printJiShu();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }, "奇数线程").start();

    }


}


class PrintNum {
    private final Object lock = new Object();

    int i = 0;

    public void printOuShu() throws InterruptedException {

        synchronized (lock) {


            while (i % 2 != 0) {
                lock.wait();
            }


            System.out.println(Thread.currentThread().getName() + ":" + i);

            i++;

            lock.notify();
        }

    }


    public void printJiShu() throws InterruptedException {
        synchronized (lock) {


            while (i % 2 == 0) {


                lock.wait();
            }


            System.out.println(Thread.currentThread().getName() + ":" + i);

            i++;

            lock.notify();
        }

    }

}

