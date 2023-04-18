package org.example;

/**
 * -Xss200m
 */
public class TestStackOOM {
    private void dontStop() {
        while (true) {
        }
    }

    public void stackLeakByThread() {
        while (true) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    dontStop();
                }
            });
            thread.start();
        }
    }

    public static void main(String[] args) throws Throwable {
        TestStackOOM oom = new TestStackOOM();
        oom.stackLeakByThread();
    }
}
