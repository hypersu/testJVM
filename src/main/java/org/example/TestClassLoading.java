package org.example;

/**
 * -XX:+TraceClassLoading
 * M warning: Ignoring option TraceClassLoading; support was removed in 16.0
 *
 * -Xlog:class*
 */
public class TestClassLoading {

    private int a;
    private String b;

    public static void main(String[] args) {
        TestClassLoading testClassLoading = new TestClassLoading();
    }
}
