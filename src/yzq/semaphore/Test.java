package yzq.semaphore;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class Test {
    public static void main(String[] args) {

        /*指定许可证的数量为3*/
        Semaphore semaphore = new Semaphore(3);

        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                try {
                    /*获取许可证*/
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName() + "拿到了许可证");
                    TimeUnit.MILLISECONDS.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    System.out.println(Thread.currentThread().getName() + "====释放了许可证");
                    /*释放许可证*/
                    semaphore.release();
                }
            }, "线程" + i).start();
        }

    }
}
