package org.example.exception;

public class Test {
    public static void main(String[] args) {
        try {
            Exception exception = new NullPointerException();
            System.out.println(exception instanceof Throwable);
            System.out.println(exception instanceof Exception);
            System.out.println(exception instanceof NullPointerException);
        } catch (Exception e) {
            System.out.println(e.getMessage() == null);
        }
    }
}
