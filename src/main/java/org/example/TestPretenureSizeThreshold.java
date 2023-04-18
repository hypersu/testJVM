package org.example;

/**
 * -verbose:gc -Xms20M -Xmx20M -Xmn10M
 * -XX:+PrintGCDetails -XX:SurvivorRatio=8
 * -XX:PretenureSizeThreshold=3145728
 */
public class TestPretenureSizeThreshold {
    private static final int _1MB = 1024 * 1024;

    public static void test() {
        byte[] allocation;
        // 直接分配在老年代
        allocation = new byte[4 * _1MB];
    }

    public static void main(String[] args) {
        test();
    }
}
