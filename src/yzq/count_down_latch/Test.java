package yzq.count_down_latch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class Test {

    public static void main(String[] args) {

        int num = 5;


        System.out.println("主线程开始执行了");
        /*创建一个给初始值的计数器*/
        CountDownLatch countDownLatch = new CountDownLatch(num);


        for (int i = 1; i <= num; i++) {
            new Thread(() -> {

                try {
                    TimeUnit.MILLISECONDS.sleep(1000);

                    System.out.println(Thread.currentThread().getName() + "执行完毕了");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {

                    /*计数器减一*/
                    countDownLatch.countDown();
                }


            }, "Thread" + i).start();
        }

        try {

            /*等待计数器的值减为0 然后再向下执行 */
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        System.out.println(num + "个接口都执行完毕了");


    }
}
