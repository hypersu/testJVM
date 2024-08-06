package org.example.base.net;

import java.io.IOException;
import java.net.StandardProtocolFamily;
import java.net.UnixDomainSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.nio.file.Path;
import java.util.LinkedList;
import java.util.List;

public class TestUnixSocketClient {

    public static String read(SocketChannel socketChannel) throws IOException {
        ByteBuffer byteBuffer = ByteBuffer.allocate(2048);
        int len;
        List<Byte> list = new LinkedList<>();
        while ((len = socketChannel.read(byteBuffer)) != -1) {
            byteBuffer.flip();
            for (int i = 0; i < len; i++) {
                byte b = byteBuffer.get();
                list.add(b);
            }
        }
        Byte[] bytes = list.toArray(new Byte[0]);
        byte[] bytes1 = new byte[bytes.length];
        for (int i = 0; i < bytes.length; i++) {
            bytes1[i] = bytes[i];
        }
        return new String(bytes1);
    }

    public static void main(String[] args) throws IOException {
        Path socketFile = Path
                .of(System.getenv("APPDATA"), "ROSETTA eCTD Viewer/temp")
                .resolve("server.socket");
        UnixDomainSocketAddress address =
                UnixDomainSocketAddress.of(socketFile);
        SocketChannel socketChannel = SocketChannel.open(StandardProtocolFamily.UNIX);
        socketChannel.connect(address);

        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        byteBuffer.put("hello, message11111111111111111111111111111111111111111111111111111111!".getBytes());
        byteBuffer.flip();
        socketChannel.write(byteBuffer);
        System.out.println(read(socketChannel));
        socketChannel.close();
    }
}
