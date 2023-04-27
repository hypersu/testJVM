package org.example.base.concurrent;

import java.util.concurrent.ConcurrentLinkedQueue;

public class TestConcurrentLinkedQueue {
    public static void main(String[] args) {
        ConcurrentLinkedQueue<String> queue=new ConcurrentLinkedQueue<>();

        queue.add("1");

        for (;;){
            String a=queue.poll();
            if(a==null){
                return;
            }
            System.out.println(a);
            queue.offer("2");
        }
    }
}
