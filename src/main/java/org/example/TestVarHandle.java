package org.example;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.VarHandle;

public class TestVarHandle {
    private String a;

    @Override
    public String toString() {
        return "a="+a;
    }

    public static void main(String[] args) throws IllegalAccessException, NoSuchFieldException {
        TestVarHandle instance = new TestVarHandle();

        VarHandle varHandle = MethodHandles
                .privateLookupIn(TestVarHandle.class,
                        MethodHandles.lookup())
                .findVarHandle(TestVarHandle.class, "a", String.class);
        varHandle.set(instance,"1212");
        System.out.println(instance);
    }
}
