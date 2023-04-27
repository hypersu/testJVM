package org.example.base.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SocketChannel;

public class Test1 {
    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            SocketChannel channel = null;
            try {
                Thread.sleep(5000);
                channel = SocketChannel.open();
                channel.connect(new InetSocketAddress("192.168.0.101", 1111));
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
}
