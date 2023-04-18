package org.example.jit.assembly;

/**
 * -XX:+UnlockDiagnosticVMOptions
 * -XX:+PrintAssembly
 * -XX:+LogCompilation
 * -XX:LogFile=C:\Users\suxiaohan\Desktop\1.log
 * -XX:+TraceClassLoading deprecated
 * -Xlog:class*
 */
public class TestJITWatch {
    static int b = 2;
    int a = 1;

    public int sum(int c) {
        return a + b + c;
    }

    public static void main(String[] args) {
        new TestJITWatch().sum(3);
    }
}
