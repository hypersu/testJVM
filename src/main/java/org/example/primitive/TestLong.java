package org.example.primitive;

public class TestLong {

    public static void main(String[] args) {
        int a = Integer.MAX_VALUE;
        long b = 1L;
        b += a;
        System.out.println(b);
        long c = 1L + Integer.MAX_VALUE;
        System.out.println(c);
        System.out.println((Integer.MAX_VALUE + 1));
        System.out.println(c == (Integer.MAX_VALUE + 1));

        // -64
        byte d = (byte) (1 << 7) | (byte) (1 << 6);
        System.out.println(d);
        System.out.println(test(d));
        System.out.println(test(64));

        // 1111 1111 1111 1111
        short e = -1;
        System.out.println((byte) e);

        // 1111 1111 0111 1111
        // 1111 1111 0111 1110
        // 1000 0000 1000 0001
        short f = -129;
        System.out.println(f);
        System.out.println((byte) f);
    }

    public static byte test(int a) {
        return (byte) a;
    }
}
