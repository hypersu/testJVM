package org.example.base.nio;

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
        serverSocketChannel.bind(new InetSocketAddress("127.0.0.1", 1111));
        serverSocketChannel.configureBlocking(false);
        Selector selector = Selector.open();
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

        Thread thread = new Thread(() -> {
            int i = 0;
            try {
                while (true) {
                    System.out.println("开始了....");
                    int s = selector.select();
                    if (s == 0) {
                        System.out.println("没有事件产生...");
                        continue;
                    }
                    Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
                    while (iterator.hasNext()) {
                        SelectionKey key = iterator.next();
                        iterator.remove();
                        System.out.println("事件掩码：" + key.readyOps());
                        if (key.isAcceptable()) {
                            i++;
                            System.out.println("accept事件" + i);
                            ServerSocketChannel ss = (ServerSocketChannel) key.channel();
                            SocketChannel socketChannel = ss.accept();
                            socketChannel.configureBlocking(false);
                            socketChannel.register(key.selector(), SelectionKey.OP_READ | SelectionKey.OP_WRITE);
                        }
                        if (key.isWritable()) {
                            System.out.println("write事件");
                        }
                        if (key.readyOps() == 0) {
                            System.out.println("未知事件");
                        }
                        if (key.isReadable()) {
                            System.out.println("read事件");
                            SocketChannel ss = (SocketChannel) key.channel();
                            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
                            while (ss.read(byteBuffer) != -1) {

                            }
                            byteBuffer.flip();
                            byteBuffer.clear();
                            ss.close();
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
