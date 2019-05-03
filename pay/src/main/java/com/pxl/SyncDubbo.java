package com.pxl;

/**
 * @author pxl
 * @description
 * @date 2019/4/26 15:29
 */
public class SyncDubbo {
    static class Main {
        public int i = 5;
        public synchronized void operationSup() {
            i--;
            System.out.println("Main print i =" + i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class Sub extends Main {
        public synchronized void operationSub() {
            while (i > 0) {
                i--;
                System.out.println("Sub print i = " + i);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        new Thread(new Runnable() {
            public void run() {
                Sub sub = new Sub();
                sub.operationSub();
            }
        }).start();
    }
}
