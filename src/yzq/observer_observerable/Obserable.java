package yzq.observer_observerable;


/**
 * @author : yuzhiqiang (zhiqiang.yu.xeon@gmail.com)
 * @description: 被观察者
 * @date : 2021/8/1
 * @time : 21:22
 */
public interface Obserable<T> {

    /*注册，相当于产生订阅关系*/
    void register(Observer<T> observer);

    /*解除注册 相当于解除订阅关系*/
    void unRegister(Observer<T> observer);

    /*发射数据  通知数据更新*/
    void next(T o);


}
