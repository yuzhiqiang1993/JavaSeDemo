package yzq.proxy.dynamic_porxy;

public class Test {
    public static void main(String[] args) {

        /*委托类*/
        final CalIml calIml = new CalIml();
//        System.out.println(calIml.add(1, 1));

        /*代理类*/
        final DynamicProxyInvocationHandler<Calculate> calculateDynamicProxyInvocationHandler = new DynamicProxyInvocationHandler<>();
        /*创建的代理对象*/
        final Calculate calculateProxy = calculateDynamicProxyInvocationHandler.create(calIml);
        System.out.println(calculateProxy.add(1, 2));
        System.out.println(calculateProxy.sub(5, 2));
        System.out.println(calculateProxy.mul(12, 19));
        System.out.println(calculateProxy.div(10, 5));

    }
}
