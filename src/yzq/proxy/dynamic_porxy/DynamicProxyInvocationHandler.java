package yzq.proxy.dynamic_porxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;


/**
 * @author : yuzhiqiang (zhiqiang.yu.xeon@gmail.com)
 * @description: 代理类
 * @date : 2021/9/4
 * @time : 15:49
 */
public class DynamicProxyInvocationHandler<T> implements InvocationHandler {


    private T obj;

    public T create(T obj) {
        this.obj = obj;
        return (T) Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        /*打印参数*/
        System.out.println(method.getName() + "的参数是：" + Arrays.toString(args));

        final Object invokeResult = method.invoke(obj, args);

        /*打印结果*/
        System.out.println("计算的结果是：" + invokeResult);


        return invokeResult;
    }
}
