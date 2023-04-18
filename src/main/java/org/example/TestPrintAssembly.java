package org.example;

/**
 * -XX:+UnlockDiagnosticVMOptions
 * -XX:+PrintAssembly
 */
public class TestPrintAssembly {

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
