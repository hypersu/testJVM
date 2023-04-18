package org.example.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

public class Test {

    public static void main(String[] args) throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.bind(new InetSocketAddress("192.168.0.101", 1111));
        serverSocketChannel.configureBlocking(false);
        Selector selector = Selector.open();
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT, SelectionKey.OP_CONNECT);

        Thread thread = new Thread(() -> {
            try {
                while (true) {
                    int s = selector.select();
                    if (s == 0) {
                        System.out.println("非阻塞....");
                        Thread.sleep(10000);
                        continue;
                    }
                    Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
                    while (iterator.hasNext()) {
                        SelectionKey key = iterator.next();
                        iterator.remove();
                        if (key.isAcceptable()) {
                            System.out.println("accept事件");
                            ServerSocketChannel ss = (ServerSocketChannel) key.channel();
                            SocketChannel socketChannel = ss.accept();
                            socketChannel.configureBlocking(false);
                            socketChannel.register(key.selector(), SelectionKey.OP_READ);
                        } else if (key.isReadable()) {
                            System.out.println("read事件");
                            SocketChannel ss = (SocketChannel) key.channel();
                            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
                            while (ss.read(byteBuffer) != -1) {

                            }
                            byteBuffer.flip();
                            System.out.println(new String(byteBuffer.array()));
                            byteBuffer.clear();
                            ss.close();
                        } else if (key.isWritable()) {
                            System.out.println("write事件");
                        } else if (key.isConnectable()) {
                            System.out.println("connect事件");
                        } else {
                            System.out.println("未知事件");
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        thread.start();
    }
}
