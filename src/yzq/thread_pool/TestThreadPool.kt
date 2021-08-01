package yzq.thread_pool

import java.util.concurrent.*

class Test {

}

fun main() {


    val availableProcessors = Runtime.getRuntime().availableProcessors()



    /*创建线程池*/
    val threadPoolExecutor = ThreadPoolExecutor(
        0,//核心线程数
        5,//允许的最大线程数
        500,//多余空闲线程的存活时间
        TimeUnit.MILLISECONDS,//存活时间单位
        ArrayBlockingQueue(3),//阻塞队列（任务等待区）
        Executors.defaultThreadFactory(),//创建线程的工厂类
        ThreadPoolExecutor.AbortPolicy()//拒绝策略
    )
    for (i in 1..5) {
        /*执行任务*/
        println("提交任务给线程池:${i}")
        threadPoolExecutor.execute {
            /*打印线程的名称*/
            TimeUnit.MILLISECONDS.sleep(100)
            println("${Thread.currentThread().name}执行了==>$i")

            println("threadPoolExecutor.isTerminated = ${threadPoolExecutor.isTerminating}")
        }
    }

    println("main执行了")

    TimeUnit.SECONDS.sleep(1)
    println(threadPoolExecutor.isShutdown)

}

