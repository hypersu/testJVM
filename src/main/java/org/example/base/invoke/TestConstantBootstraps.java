package org.example.base.invoke;

import java.lang.invoke.ConstantBootstraps;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.VarHandle;

public class TestConstantBootstraps {
    private int a = 5;

    public int getA() {
        return a;
    }

    public static void main(String[] args) {
        TestConstantBootstraps test = new TestConstantBootstraps();

        VarHandle varHandle = ConstantBootstraps.fieldVarHandle(MethodHandles.lookup(),
                "a", VarHandle.class,
                TestConstantBootstraps.class,
                int.class);

        int oldA = (int) varHandle.getAndAdd(test, 3);
        System.out.println(oldA);
        System.out.println(test.getA());
    }
}
