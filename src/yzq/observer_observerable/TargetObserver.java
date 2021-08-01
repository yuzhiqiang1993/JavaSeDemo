package yzq.observer_observerable;


/**
 * @author : yuzhiqiang (zhiqiang.yu.xeon@gmail.com)
 * @description: 观察者实现类
 * @date : 2021/8/1
 * @time : 21:27
 */
public class TargetObserver<T> implements Observer<T> {


    private final String name;

    public TargetObserver(String name) {
        this.name = name;
    }

    @Override
    public void onNext(T data) {

        System.out.println(name + "--->next:" + data);
    }
}
