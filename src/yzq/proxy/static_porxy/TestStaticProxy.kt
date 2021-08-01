package yzq.proxy.static_porxy

class TestStaticProxy : Phone {


    lateinit var phone: Phone


    override fun sale() {
        println("代理开始买手机")
        phone.sale()
    }
}


fun main() {


    val xiaoMi = XiaoMi()
    val huaWei = HuaWei()
    val testStaticProxy = TestStaticProxy()
    testStaticProxy.phone = xiaoMi

    testStaticProxy.sale()

    testStaticProxy.phone = huaWei
    testStaticProxy.sale()


}