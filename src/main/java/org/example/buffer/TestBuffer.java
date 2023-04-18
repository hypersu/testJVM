package org.example.buffer;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.charset.Charset;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class TestBuffer {
    public static void main(String[] args) throws IOException {
        FileChannel channel = null;
        FileLock lock = null;
        try {
            channel = FileChannel.open(Paths.get("C:\\Users\\suxiaohan\\Desktop\\1.txt"),
                    StandardOpenOption.READ, StandardOpenOption.WRITE);
            lock = channel.lock();
            System.out.println(channel.size());
            ByteBuffer buffer = ByteBuffer.allocate(64);
            int len = channel.read(buffer);
            if (len > 0) {
                buffer.flip();
                Charset charset = Charset.defaultCharset();
                String s = charset.decode(buffer).toString();
                Long l = Long.valueOf(s);
                l += 1;
                buffer.clear();
                buffer.put(l.toString().getBytes());
                buffer.flip();
                channel.write(buffer, 0);
                channel.force(true);
            } else {
                // 8个字节
                buffer.clear();
                buffer.putLong(1234567890L);
                buffer.flip();
                channel.write(buffer);
                channel.force(true);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            lock.close();
            channel.close();
        }
    }
}
