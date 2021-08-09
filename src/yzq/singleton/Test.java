package yzq.singleton;

public class Test {

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {

            new Thread(() -> {
                System.out.println("DoubleCheckLockSingleton.getSingleton() = " + DoubleCheckLockSingleton.getSingleton());

            }).start();
        }
    }
}
