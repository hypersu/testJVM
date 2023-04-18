package org.example.classloader;

import java.net.URL;

public class TestClassLoader {

    public static void main(String[] args) {
        URL url = TestClassLoader.class.getClassLoader().getResource("");
        System.out.println(url.getPath());

        URL url1 = TestClassLoader.class.getResource("");
        System.out.println(url1.getPath());


        ClassLoader classLoader = TestClassLoader.class.getClassLoader().getParent();
        System.out.println(classLoader);
        System.out.println(classLoader.getParent());

        System.out.println(ClassLoader.getSystemClassLoader());
    }
}
