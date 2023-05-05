package org.example;

/**
 * -XX:+DisableExplicitGC
 * -Xlog:gc*
 */
public class TestDisableExplicitGC {
    private byte[] bytes = new byte[1024 * 64];

    public static void main(String[] args) throws InterruptedException {
        TestDisableExplicitGC gc = new TestDisableExplicitGC();
        System.gc();

        Thread.sleep(10000);
    }
}
