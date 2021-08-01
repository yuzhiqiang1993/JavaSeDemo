package yzq.proxy.dynamic_porxy;

import yzq.proxy.static_porxy.HuaWei;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Test {

    public static void main(String[] args) {


        HuaWei huaWei = new DynamicProxy<HuaWei>().create(new HuaWei());

        huaWei.sale();
    }

}


class DynamicProxy<T> implements InvocationHandler {

    private T t;

    public T create(T t) {
        this.t = t;

        return (T) Proxy.newProxyInstance(t.getClass().getClassLoader(), t.getClass().getInterfaces(), this);

    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return method.invoke(t, args);
    }
}
