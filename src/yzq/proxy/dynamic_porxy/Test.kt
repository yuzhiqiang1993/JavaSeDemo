package yzq.proxy.dynamic_porxy

import yzq.proxy.static_porxy.HuaWei
import yzq.proxy.static_porxy.Phone
import java.lang.reflect.Proxy


fun main() {

    val huaWei = create<HuaWei>()
    huaWei.sale()
}

class PhoneProxy(phone: Phone) : Phone by phone

inline fun <reified T : Any> create(): T {

    val obj:T

    val java = T::class.java

    println("java = ${java}")

    val classLoader = java.classLoader
    println("classLoader = ${classLoader}")

    val interfaces = java.interfaces
    interfaces.forEach {
        println("it = ${it}")
    }

    return Proxy.newProxyInstance(
        classLoader,
        interfaces
    ) { proxy, method, args ->

        println("proxy = ${proxy}")
        println("method = ${method}")
        println("args = ${args}")

        return@newProxyInstance method.invoke(proxy, args)


    } as T

}