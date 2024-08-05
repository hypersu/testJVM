package org.example.base.net;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.StandardProtocolFamily;
import java.net.UnixDomainSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;

public class TestUnixSocket {
    public static void main(String[] args) throws IOException {
        System.out.println(System.getenv("APPDATA"));
        Path socketFile = Path
                .of(System.getenv("APPDATA"), "ROSETTA eCTD Viewer/temp")
                .resolve("server.socket");
        Files.deleteIfExists(socketFile);
        UnixDomainSocketAddress address =
                UnixDomainSocketAddress.of(socketFile);
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open(StandardProtocolFamily.UNIX);
        serverSocketChannel.bind(address);
        System.out.println(serverSocketChannel.isBlocking());

        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        while(true) {
            SocketChannel channel = serverSocketChannel.accept();
            channel.read(byteBuffer);
            byteBuffer.flip();
            System.out.println(Charset.defaultCharset().decode(byteBuffer));
            channel.close();
        }
    }
}
