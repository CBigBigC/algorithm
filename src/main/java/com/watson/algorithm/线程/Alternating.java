package com.watson.algorithm.线程;

/**
 * 写两个线程，一个线程打印1~ 52，另一个线程打印A~Z，打印顺序是12A34B…5152Z
 */
public class Alternating {

    private boolean mark;

    public synchronized void print1() {
        for (int i = 0; i < 52; i += 2) {
            while (mark) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.print(i + 1);
            System.out.print(i + 2);
            mark = !mark;
            notify();
        }
    }

    public synchronized void print2() {
        for (int i = 0; i < 26; i++) {
            while (!mark) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            mark = !mark;
            System.out.print((char) ('A' + i));
            notify();
        }
    }

    public static void main(String[] args) {
        Alternating alternating = new Alternating();
        new Thread(alternating::print1).start();
        new Thread(alternating::print2).start();
        System.gc();
    }


}
