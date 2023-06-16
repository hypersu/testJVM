package org.example.base.reflect;

import java.lang.annotation.*;

public class TestAnnotation {

    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Log {
        String value() default "";
    }

    public interface Parent extends ParentParent{
        @Log("i am parent log")
        void test();
    }

    public interface ParentParent {
        @Log("i am parent parent log")
        void test();
    }

    public static class Son implements Parent {
        @Override
        public void test() {
            System.out.println("test() i am son");
        }
    }

    public static void main(String[] args) throws NoSuchMethodException {
        Son son = new Son();
        Class sonClass = son.getClass();
        Class[] superClass = sonClass.getInterfaces();
        for (Class aClass : superClass) {
            System.out.println(aClass.getName());
        }
        Annotation[] annotations = superClass[0].getMethod("test").getAnnotations();
        for (Annotation a :
                annotations) {
            System.out.println(a);
        }
    }
}
