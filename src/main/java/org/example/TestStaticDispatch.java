package org.example;

public class TestStaticDispatch {
    public void sysHello(int a){
        System.out.println(a);
    }


    public void sysHello(char b){
        System.out.println(b);
    }

    public static void main(String[] args) {
        TestStaticDispatch t=new TestStaticDispatch();
        t.sysHello(111);
        t.sysHello('3');
    }
}
