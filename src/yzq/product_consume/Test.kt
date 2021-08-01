package yzq.product_consume

import java.util.concurrent.TimeUnit
import kotlin.concurrent.thread

fun main() {

    val shop = Shop()


    /*生产者线程*/
    thread {
        while (true) {
            TimeUnit.MILLISECONDS.sleep(10)
            shop.product()
        }

    }

    /*消费者线程*/
    thread {
        while (true) {
            TimeUnit.MILLISECONDS.sleep(20)
            shop.consume()
        }

    }

}