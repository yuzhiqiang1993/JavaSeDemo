package yzq.cyclicbarrier;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

public class Test {
    public static void main(String[] args) {
        int num = 10;

        int parties = 3;//屏障点
        System.out.println("主线程开始执行了");
        /*构造器传入一个达成条件要执行await的数量以及达到条件后要执行的任务*/
        CyclicBarrier cyclicBarrier = new CyclicBarrier(parties, () -> System.out.println(Thread.currentThread().getName() + " 发现成团条件达成了...."));

        for (int i = 1; i <= num; i++) {

            int finalI = i;
            new Thread(() -> {

                try {
                    TimeUnit.MILLISECONDS.sleep(finalI * 1000L);
                    System.out.println(Thread.currentThread().getName() + "开始拼团");
                    /*调用一下await  就会触发*/
                    cyclicBarrier.await();
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }, "线程" + i).start();
        }


        System.out.println("主线程执行到这了......");
    }
}
