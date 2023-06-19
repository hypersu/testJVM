package org.example.base.reflect;

public class TestInvocation {

    public interface IParent {
        void test();
    }

    public static class Parent {
        public void test() {
            System.out.println("i am parent");
        }
    }

    public static class SonImpl implements IParent {
        private String a = "填充";
        @Override
        public void test() {
            System.out.println("i am son");
        }

        public void test1() {
            System.out.println("i am son");
        }
    }

    public static class Son extends Parent {
        private String a = "填充";

        @Override
        public void test() {
            System.out.println("i am son");
        }

        public void test1() {
            System.out.println("i am son");
        }
    }

    public static void main(String[] args) throws Exception {
        // 接口测试
        Class clazzInterface = IParent.class;
        SonImpl Impl = new SonImpl();
        clazzInterface.getMethod("test").invoke(Impl);
        // 父类没有该方法
        // clazz.getMethod("test1").invoke(son);
        // 类测试
        Class clazz = Parent.class;
        Son son = new Son();
        clazz.getMethod("test").invoke(son);
    }
}
