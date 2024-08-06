package org.example.base.property;

public class Test {
    public static void main(String[] args) {
        System.out.println(System.getProperty("sun.java.command"));
        System.out.println(System.getProperty("user.home"));
        System.out.println(System.getProperty("java.io.tmpdir"));
    }
}
