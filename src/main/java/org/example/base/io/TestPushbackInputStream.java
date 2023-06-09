package org.example.base.io;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PushbackInputStream;

public class TestPushbackInputStream {
    public static void main(String[] args) {
        String str = "Hello World!";
        try (InputStream input = new ByteArrayInputStream(str.getBytes());
             PushbackInputStream pushbackInput = new PushbackInputStream(input,10)) {
            byte[] buffer = new byte[10];
            int length;
            while ((length = pushbackInput.read(buffer)) != -1) {
                String s = new String(buffer, 0, length);
                System.out.println("Read " + s);
                if (s.contains("o")) {
                    pushbackInput.unread(s.getBytes());
                    break;
                }
            }
            length = pushbackInput.read(buffer);
            if (length != -1) {
                System.out.println("Backtrack " + new String(buffer, 0, length));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
