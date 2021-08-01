package yzq.product_consume

import java.util.concurrent.locks.ReentrantLock

class Shop {

    /*保存数据的集合*/
    private val dataList = mutableListOf<String>()

    /*锁*/
    private val lock = ReentrantLock()

    /*控制条件*/
    private val condition = lock.newCondition()

    /*计数*/
    private var cout = 0

    /**
     * 生产
     */
    fun product() {

        lock.lock()

        try {
            while (dataList.size >= 5) {

                condition.await()
            }

            cout++
            println("生产了新数据：${cout}")


            dataList.add("${cout}")


            condition.signalAll()
        } catch (e: Exception) {

        } finally {
            lock.unlock()
        }
    }


    /**
     * 消费
     */
    fun consume() {

        lock.lock()

        try {

            while (dataList.size == 0) {
                condition.await()
            }

            println("消费了数据:${dataList.removeAt(0)}")

            condition.signalAll()

        } catch (e: Exception) {

        } finally {
            lock.unlock()
        }

    }

}