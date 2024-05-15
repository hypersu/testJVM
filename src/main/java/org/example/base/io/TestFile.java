package org.example.base.io;

import java.io.File;

public class TestFile {
    public static void main(String[] args) {
        File file = new File("C:\\Users\\DB-User\\Desktop\\aaa\\bbb");
        if(!file.exists()) {
            file.mkdirs();
        }
    }
}
