package yzq.observer_observerable;

import java.util.concurrent.CopyOnWriteArrayList;


/**
 * @author : yuzhiqiang (zhiqiang.yu.xeon@gmail.com)
 * @description: 被观察者实现类
 * @date : 2021/8/1
 * @time : 21:26
 */
public class TargetObserable<T> implements Obserable<T> {


    /*线程安全的列表  用于存放所有 观察者 对象*/
    private final CopyOnWriteArrayList<Observer> copyOnWriteArrayList = new CopyOnWriteArrayList<>();

    @Override
    public void register(Observer observer) {

        this.copyOnWriteArrayList.add(observer);
    }

    @Override
    public void unRegister(Observer observer) {
        if (copyOnWriteArrayList.contains(observer)) {
            this.copyOnWriteArrayList.remove(observer);
        }
    }

    @Override
    public void next(T o) {

        this.copyOnWriteArrayList.forEach(it -> {
            it.onNext(o);
        });

    }
}
