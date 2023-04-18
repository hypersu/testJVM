package org.example;

/**
 * -Xss128k
 */
public class TestStackOF {
    private int stackLength = 1;

    public void stackLeak() {
        stackLength++;
        stackLeak();
    }

    public static void main(String[] args) {
        TestStackOF testStackOF = new TestStackOF();
        try {
            testStackOF.stackLeak();
        } catch (Throwable e) {
            System.out.println(testStackOF.stackLength);
            throw e;
        }
    }
}
