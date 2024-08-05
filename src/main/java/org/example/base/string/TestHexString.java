package org.example.base.string;

import java.util.Random;

public class TestHexString {

    public static void main(String[] args) {
        String type = "1";
        Random random = new Random();
        int lastHex = random.nextInt(15);
        System.out.println(Integer.toHexString(lastHex));
        int result = 0;
        if (Integer.parseInt(type) == 1) {
            result = 0xf0;
        }
        result += lastHex;

        System.out.println(String.format("%02x", result).toUpperCase());
    }
}
