package yzq.observer_observerable;

public class Test {

    public static void main(String[] args) {
        /*被观察者对象*/
        TargetObserable<String> stringTargetObserable = new TargetObserable<>();
        /*观察者对象1*/
        TargetObserver<String> stringTargetObserver = new TargetObserver<>("观察者1");
        /*观察者对象2*/
        TargetObserver<String> stringTargetObserver1 = new TargetObserver<>("观察者2");

        /*产生订阅关系*/
        stringTargetObserable.register(stringTargetObserver);
        stringTargetObserable.register(stringTargetObserver1);
        /*被观察者 数据 变化  通所有观察者*/
        stringTargetObserable.next("测试");

        /*解除注册*/
        stringTargetObserable.unRegister(stringTargetObserver);
        stringTargetObserable.next("测试1");

    }
}
