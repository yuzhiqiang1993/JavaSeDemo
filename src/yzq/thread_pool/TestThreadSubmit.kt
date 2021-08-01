package yzq.thread_pool

import java.util.concurrent.ArrayBlockingQueue
import java.util.concurrent.Executors
import java.util.concurrent.ThreadPoolExecutor
import java.util.concurrent.TimeUnit


fun main() {
    val threadPoolExecutor = ThreadPoolExecutor(
        2,
        5,
        200,
        TimeUnit.MILLISECONDS,
        ArrayBlockingQueue(5),
        Executors.defaultThreadFactory(),
        ThreadPoolExecutor.AbortPolicy()
    )


    try {
        val futureTask = threadPoolExecutor.submit<String> {
            TimeUnit.SECONDS.sleep(1)
            "这是返回结果"
        }

        println(futureTask.get())//这里会阻塞住后面的代码
    } catch (e: Exception) {
        e.printStackTrace()
    } finally {
        threadPoolExecutor.shutdown()
    }
    println("main")

}