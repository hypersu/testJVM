package org.example;

import java.util.Map;

public class TestGetAllStackTraces {

    public static void main(String[] args) {
        Map<Thread, StackTraceElement[]> map = Thread.getAllStackTraces();
        for (Map.Entry<Thread, StackTraceElement[]> entry : map.entrySet()) {
            System.out.println("thread Name:"+entry.getKey().getName());
            StackTraceElement[] elements=entry.getValue();
            for (StackTraceElement ele :
                    elements) {
                System.out.println(ele);
            }
        }
    }
}
