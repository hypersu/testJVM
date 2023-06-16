package org.example.base.reflect;

import java.lang.reflect.Method;

public class TestClass {
    public void test() {

    }

    public static void main(String[] args) throws NoSuchMethodException {
        TestClass testClass1 = new TestClass();
        Class c1 = testClass1.getClass();
        TestClass testClass2 = new TestClass();
        Class c2 = testClass2.getClass();
        System.out.println(c1 == c2);

        Method m1 = c1.getMethod("test");
        Method m2 = c2.getMethod("test");
        System.out.println(m1 == m2);
    }
}
