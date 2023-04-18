package org.example;

/**
 * -Dcom.sun.management.jmxremote.port=1099
 * -Dcom.sun.management.jmxremote.rmi.port=9999
 * -Dcom.sun.management.jmxremote.authenticate=false
 * -Dcom.sun.management.jmxremote.ssl=false
 * -XX:+FlightRecorder deprecated
 */
public class TeatJMX {
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 1000; i++) {
            Thread.sleep(1000);
        }
    }
}
