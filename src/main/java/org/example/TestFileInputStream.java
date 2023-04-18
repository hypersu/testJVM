package org.example;

import java.io.File;
import java.io.FileInputStream;

public class TestFileInputStream {
    public static void main(String[] args) throws Exception {
        FileInputStream in = new FileInputStream("C:\\Users\\suxiaohan\\Desktop\\11.txt");
        // jdk16
        // System.out.println(in.readAllBytes());

        System.out.println(111);

    }
}
