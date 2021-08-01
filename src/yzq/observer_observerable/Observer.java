package yzq.observer_observerable;


/**
 * @author : yuzhiqiang (zhiqiang.yu.xeon@gmail.com)
 * @description: 观察者接口
 * @date : 2021/8/1
 * @time : 21:09
 */
public interface Observer<T> {

    /**
     * 观察到 被观察者 的数据发生变化
     *
     * @param data
     */
    void onNext(T data);
}
