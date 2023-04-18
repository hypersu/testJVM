package org.example;

/**
 * -noverify -Xverify:none
 */
public class TestBTrace {
    public int add(int a, int b) {
        return a + b;
    }

    public static void main(String[] args) throws InterruptedException {
        TestBTrace testBTrace = new TestBTrace();
        for (int i = 0; i < 1000; i++) {
            Thread.sleep(1000);
            int a = (int) Math.round(Math.random() * 1000);
            int b = (int) Math.round(Math.random() * 1000);
            System.out.println(testBTrace.add(a, b));
        }
    }
}
