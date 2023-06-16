package org.example.base.reflect;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TestList {
    public void test(List<Serializable> list){

    }

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        List<Object> list = new LinkedList<>();
        list.add("1111");
        TestList testList = new TestList();
        // 失败
        // testList.test(list);
        List list1 = new ArrayList(); // 使用了原始类型 List
        list1.add("hello");
        list1.add(new Object());
        String str = (String) list1.get(0); // 需要强制类型转换
        List<String> list2 = new ArrayList(); // 使用了原始类型 List
        list2.add("hello");
        for (Object o :list) {

        }
    }
}
