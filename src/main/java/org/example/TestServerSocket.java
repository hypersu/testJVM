package org.example;

import java.io.IOException;
import java.net.ServerSocket;

public class TestServerSocket {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(1111);
        while (!serverSocket.isClosed()) {
            serverSocket.accept();
            System.out.println("连接来了");
        }
    }
}
