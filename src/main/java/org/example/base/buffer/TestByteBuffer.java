package org.example.base.buffer;

import java.nio.ByteBuffer;
import java.util.Arrays;

public class TestByteBuffer {

    public static void main(String[] args) {
        ByteBuffer buffer =  ByteBuffer.allocate(10);
        buffer.put("hello".getBytes());
        byte[] array = buffer.array();
        System.out.println(array.length);
        System.out.println(Arrays.toString(array));
        int position = buffer.position();
        buffer.flip();
        for (int i = 0; i < position; i++) {
            System.out.println(buffer.get());
        }
    }
}
