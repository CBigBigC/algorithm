package com.watson.algorithm.线程;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OrderThread {

    private static final Logger log = LoggerFactory.getLogger(OrderThread.class);

    static class OrderT extends Thread {

        OrderT(String name) {
            super(name);
        }

        public void run(){
            for(int i = 0; i < 10; i++){
                System.out.println(getName() + " : " + i);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public static void main(String[] args) {
        OrderT o1 = new OrderT("o1");
        OrderT o2 = new OrderT("o2");
        OrderT o3 = new OrderT("o3");

        try {
            o1.start();
//            o1.join();

            o2.start();
//            o2.join();

            o3.start();
//            o3.join();
        } catch (Exception e) {
            log.info("线程调度出错");
        }
    }
}
