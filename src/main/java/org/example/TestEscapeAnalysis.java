package org.example;

/**
 * -XX:+EliminateAllocations、-XX:+PrintEscapeAnalysis(debug才有)
 * -XX:+PrintGCDetails
 */
public class TestEscapeAnalysis {

    static class Pointer{
        int x;
        int y;
    }

    public static void main(String[] args) {
        Pointer p=new Pointer();
        p.x=1;
        p.y=2;
    }
}
