package org.example.base.io;

import java.io.File;

public class TestFile {
    public static void main1(String[] args) {
        File file = new File("C:\\Users\\DB-User\\Desktop\\aaa\\bbb");
        if(!file.exists()) {
            file.mkdirs();
        }
    }

    public static void main(String[] args) {
        File file = new File("C:\\Users\\DB-User\\Desktop\\aaa\\bbb");
        System.out.println(file.lastModified());
        System.out.println(file.length());
        System.out.println(file.isDirectory());
    }
}
