package org.example;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class TestFileLock {
    public static void main(String[] args) throws Exception {
        Thread thread = new Thread(() -> {
            try {
                FileChannel channel = FileChannel.open(Paths.get("C:\\Users\\suxiaohan\\Desktop\\111.txt"), StandardOpenOption.READ, StandardOpenOption.WRITE);
                FileLock lock = channel.lock();
                ByteBuffer byteBuffer = ByteBuffer.allocate(10);
                channel.read(byteBuffer);
                System.out.println(new String(byteBuffer.array()));
                Thread.sleep(10000);
                lock.release();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        thread.start();
        Thread.sleep(5000);
        Thread thread1 = new Thread(() -> {
            FileInputStream in = null;
            try {
                in = new FileInputStream("C:\\Users\\suxiaohan\\Desktop\\111.txt");
                byte[] bytes=new byte[10];
                in.read(bytes);
                System.out.println(new String(bytes));
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        });
        thread1.start();
    }
}
