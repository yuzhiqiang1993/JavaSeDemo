package yzq.singleton;


/**
 * @author : yuzhiqiang (zhiqiang.yu.xeon@gmail.com)
 * @description: 双重校验锁的单例
 * @date : 2021/8/8
 * @time : 12:46
 */
public class DoubleCheckLockSingleton {


    private static DoubleCheckLockSingleton singleton = null;


    private DoubleCheckLockSingleton() {
    }

    public static DoubleCheckLockSingleton getSingleton() {
        if (singleton == null) {
            synchronized (DoubleCheckLockSingleton.class) {
                if (singleton == null) {
                    singleton = new DoubleCheckLockSingleton();
                }
            }
        }
        return singleton;
    }
}
