package org.example;

import java.util.ArrayList;
import java.util.List;

/**
 * VM Args -Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
 */
public class TestHeadOOM {
    public static void main(String[] args) {
        List<Object> list = new ArrayList<>();
        for (; ; ) {
            list.add(new Object());
        }
    }
}
