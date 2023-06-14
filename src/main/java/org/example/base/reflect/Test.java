package org.example.base.reflect;

import java.util.LinkedList;
import java.util.List;

public class Test {

    public static void main(String[] args) {
        List<Test> list = new LinkedList<>();
        Class clazz=list.getClass();
        System.out.println(clazz.getName());
    }
}
