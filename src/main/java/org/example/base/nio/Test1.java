package org.example.base.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SocketChannel;

public class Test1 {
    public static void test() {
        Thread thread1 = new Thread(() -> {
            SocketChannel channel = null;
            try {
                channel = SocketChannel.open();
                channel.connect(new InetSocketAddress("127.0.0.1", 1111));
                channel.shutdownOutput();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    channel.close();
                } catch (IOException e) {
                }
            }
        });

        thread1.start();
    }

    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {
            test();
        }
    }
}
