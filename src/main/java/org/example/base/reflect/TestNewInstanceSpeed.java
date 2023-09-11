package org.example.base.reflect;

public class TestNewInstanceSpeed {
    //测试代码如下
    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        proxyObject();
        newObject();
    }

    //new 创建对象
    //5
    public static void newObject() {
        long startTime = System.currentTimeMillis();
        int i;
        for (i = 0; i < 100000000; i++) {
            TestNewInstanceSpeed reflectDemo = new TestNewInstanceSpeed();
        }
        if (i == 100000000) {
            long endTime = System.currentTimeMillis();
            System.out.println("new耗时为:" + (endTime - startTime));
        }
    }

    //反射 创建对象
    //30
    public static void proxyObject() throws IllegalAccessException, InstantiationException {
        long startTime = System.currentTimeMillis();
        Class<TestNewInstanceSpeed> reflectDemoClass = TestNewInstanceSpeed.class;
        int i;
        for (i = 0; i < 100000000; i++) {
            TestNewInstanceSpeed reflectDemo = reflectDemoClass.newInstance();
        }
        if (i == 100000000) {
            long endTime = System.currentTimeMillis();
            System.out.println("反射耗时为:" + (endTime - startTime));
        }
    }
}
