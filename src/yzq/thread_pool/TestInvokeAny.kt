package yzq.thread_pool

import java.util.concurrent.*


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


    val runAsync = CompletableFuture.runAsync {


    }




    /*任务集合*/
    val arrayListOfCallable = arrayListOf<Callable<String>>(
        Callable {
            TimeUnit.MILLISECONDS.sleep(100)
            "返回结果1"
        },
        Callable {
            TimeUnit.MILLISECONDS.sleep(60)
            "返回结果2"
        },
        Callable {
            TimeUnit.MILLISECONDS.sleep(80)
            "返回结果3"
        },
    )


    try {

        val invokeAnyResult = threadPoolExecutor.invokeAny(arrayListOfCallable)
        println(invokeAnyResult)//这里会阻塞住后面的代码
    } catch (e: Exception) {
        e.printStackTrace()
    } finally {
        threadPoolExecutor.shutdown()
    }
    println("main")

}