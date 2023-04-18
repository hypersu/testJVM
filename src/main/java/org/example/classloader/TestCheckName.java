package org.example.classloader;

public class TestCheckName {
    public static void main(String[] args) throws ClassNotFoundException {
        ClassLoader classLoader = TestCheckName.class.getClassLoader();
        classLoader.loadClass(null);
    }
}
