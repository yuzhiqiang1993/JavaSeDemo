package yzq.thread_pool

import java.util.concurrent.Executors
import java.util.concurrent.ThreadPoolExecutor
import java.util.concurrent.TimeUnit
import kotlin.concurrent.thread


fun main() {

    val newSingleThreadExecutor = Executors.newSingleThreadExecutor()
    val newFixedThreadPool = Executors.newFixedThreadPool(3)
    val newCachedThreadPool = Executors.newCachedThreadPool()
    val newWorkStealingPool = Executors.newWorkStealingPool()
    val newScheduledThreadPool = Executors.newScheduledThreadPool(3)




    thread {

    }
    for (i in 1..2) {
        newCachedThreadPool.execute {
            println("newCachedThreadPool = ${newCachedThreadPool}")
            println("${Thread.currentThread().name}====>${i}")
        }
    }

    TimeUnit.SECONDS.sleep(62)

    newCachedThreadPool.execute {
        println("newCachedThreadPool = ${newCachedThreadPool}")
        println("60秒之后再次执行任务")
    }


}

