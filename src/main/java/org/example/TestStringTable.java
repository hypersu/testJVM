package org.example;

import java.util.ArrayList;
import java.util.List;

/**
 * -Xms10m -Xmx10m -XX:+UseSerialGC -Xlog:gc*
 */
public class TestStringTable {
    public static void test() throws InterruptedException {
        List<String> a=new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            Thread.sleep(1000);
            a.add(("呵呵"+i).intern());
        }
    }
    public static void main(String[] args) throws InterruptedException {
        test();
    }
}
