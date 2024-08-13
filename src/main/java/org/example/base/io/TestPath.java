package org.example.base.io;

import java.io.File;
import java.nio.file.Path;

public class TestPath {
    public static void main(String[] args) {
        Path path = Path.of("C:\\Users\\DB-User\\Desktop\\aaa\\bbb", "..\\");
        System.out.println(path);
    }
}
