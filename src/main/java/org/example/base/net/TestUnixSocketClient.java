package org.example.base.net;

import java.io.IOException;
import java.net.StandardProtocolFamily;
import java.net.UnixDomainSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.nio.file.Path;

public class TestUnixSocketClient {
    public static void main(String[] args) throws IOException {
        Path socketFile = Path
                .of(System.getenv("APPDATA"), "ROSETTA eCTD Viewer/temp")
                .resolve("server.socket");
        UnixDomainSocketAddress address =
                UnixDomainSocketAddress.of(socketFile);
        SocketChannel socketChannel = SocketChannel.open(StandardProtocolFamily.UNIX);
        socketChannel.connect(address);

        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        byteBuffer.put("hello, message!".getBytes());
        byteBuffer.flip();
        socketChannel.write(byteBuffer);
        socketChannel.close();
    }
}
