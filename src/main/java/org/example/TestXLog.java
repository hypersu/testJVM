package org.example;

public class TestXLog {
    public static void main(String[] args) throws InterruptedException {
        A a = new A();
        int i = 0;
        for (; ;
        ) {
            i++;
            if (i < 5) {
                a = new A();
            }
            Thread.sleep(50000000);
        }
    }

    public static class A {
        private byte[] cache = null;
    }
}
