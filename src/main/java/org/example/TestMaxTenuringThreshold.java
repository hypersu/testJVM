package org.example;

/**
 * -verbose:gc -Xms20M -Xmx20M -Xmn10M
 * -XX:+PrintGCDetails -XX:SurvivorRatio=8
 * -XX:MaxTenuringThreshold=1
 * -XX:+PrintTenuringDistribution
 */
public class TestMaxTenuringThreshold {
    private static final int _1MB = 1024 * 1024;

    public static void test() {
        byte[] allocation1, allocation2, allocation3;
        // 什么时候进入老年代
        // 决定于-XX:MaxTenuringThreshold设置
        allocation1 = new byte[_1MB / 4];
        System.out.println(1);
        allocation2 = new byte[4 * _1MB];
        System.out.println(2);
        allocation3 = new byte[4 * _1MB];
        System.out.println(3);
        allocation3 = null;
        System.out.println(4);
        allocation3 = new byte[4 * _1MB];
        System.out.println(5);
    }

    public static void main(String[] args) {
        test();
    }
}
