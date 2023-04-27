package org.example.base.time;

import java.time.Duration;

public class TestTime {
    public static void main(String[] args) {
        System.out.println(Duration.ofMillis(-1).getNano());
    }
}
