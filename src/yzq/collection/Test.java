package yzq.collection;

import java.util.HashMap;
import java.util.HashSet;
import java.util.concurrent.CopyOnWriteArrayList;

public class Test {

    public static void main(String[] args) {
        CopyOnWriteArrayList<String> stringCopyOnWriteArrayList = new CopyOnWriteArrayList<>();


        HashSet<String> strings = new HashSet<>();

        for (int i = 0; i < 20; i++) {
            int finalI = i;
            new Thread(() -> {
                stringCopyOnWriteArrayList.add(String.valueOf(finalI));
                System.out.println("strings = " + stringCopyOnWriteArrayList);
            }).start();
        }

    }

}
