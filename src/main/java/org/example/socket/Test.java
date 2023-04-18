package org.example.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Test {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(1111);

        Thread t1 = new Thread(() -> {
            try {
                while (!server.isClosed()) {
                    Socket socket = server.accept();
                    OutputStream out = socket.getOutputStream();
                    Thread.sleep(3000);
                    out.write(1);
                    out.flush();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        t1.start();

        Thread t2 = new Thread(() -> {
            try {
                Socket socket = new Socket("localhost", 1111);
                InputStream in = socket.getInputStream();
                OutputStream out = socket.getOutputStream();
                Thread.sleep(5000);
                out.close();
                System.out.println(in.read());
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        t2.start();
    }
}
