package org.example;

/**
 * -Xms20M -Xmx20M
 * -XX:+HeapDumpOnOutOfMemoryError
 * -XX:HeapDumpPath
 */
public class TestThreadDump {
    private static final int _1MB = 1024 * 1024;
    private byte[] bytes = new byte[10*_1MB];

    public static void main(String[] args) throws InterruptedException {
        TestThreadDump threadDump1 =new TestThreadDump();
        TestThreadDump threadDump2 =new TestThreadDump();
    }
}
