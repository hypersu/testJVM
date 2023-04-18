package org.example;

public class TestJDP {
    public static void main(String[] args) {
        System.out.println(System.getProperty("com.sun.management.jmxremote.autodiscovery"));
        System.out.println(System.getProperty("com.sun.management.jmxremote"));
        System.out.println(System.getProperty("com.sun.management.jmxremote.port"));
    }
}
