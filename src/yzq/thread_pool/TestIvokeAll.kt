package yzq.thread_pool

import java.util.concurrent.*

fun main() {

    /*获取当前设备CPU的核数*/
    val availableProcessors = Runtime.getRuntime().availableProcessors()
    println("availableProcessors = ${availableProcessors}")

    val threadPoolExecutor = ThreadPoolExecutor(
        3,
        availableProcessors*2,
        200,
        TimeUnit.MILLISECONDS,
        ArrayBlockingQueue(5),
        Executors.defaultThreadFactory(),
        ThreadPoolExecutor.AbortPolicy()
    )


//    /*任务集合*/
//    val arrayListOfCallable = arrayListOf<Callable<String>>(
//        Callable {
//            TimeUnit.MILLISECONDS.sleep(100)
//            "返回结果1"
//        },
//        Callable {
//            TimeUnit.MILLISECONDS.sleep(60)
//
//            1 / 0
//            "返回结果2"
//        },
//        Callable {
//            TimeUnit.MILLISECONDS.sleep(80)
//            "返回结果3"
//        },
//    )
//
//
//    try {
//
//        val invokeAllResult = threadPoolExecutor.invokeAll(arrayListOfCallable)
//
//        println("invokeAllResult = ${invokeAllResult}")
//        invokeAllResult.forEach {
//            try {
//                println(it.get())
//            } catch (e: Exception) {
//                println("异常了")
//            } finally {
//            }
//        }
//
//    } catch (e: Exception) {
//        e.printStackTrace()
//    } finally {
//        threadPoolExecutor.shutdown()
//    }
}