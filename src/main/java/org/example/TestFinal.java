package org.example;

public class TestFinal {
    public final void test() {
        System.out.println(111);
    }

    public static void main(String[] args) {
        TestFinal testFinal = new TestFinal();
        testFinal.test();
    }
}
