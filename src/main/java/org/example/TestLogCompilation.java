package org.example;

/**
 * -XX:+UnlockDiagnosticVMOptions
 * -XX:+LogCompilation
 * -XX:LogFile=111.log
 * -Xlog:compilation
 * -XX:+PrintCompilation
 */
public class TestLogCompilation {

    public static void test(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {

        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {
            test();
        }
    }
}
