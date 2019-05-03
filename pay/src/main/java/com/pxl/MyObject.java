package com.pxl;

/**
 * @author pxl
 * @description
 * @date 2019/4/26 10:11
 */
public class MyObject {
    public void method() {
        System.out.println(Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        final MyObject myObject = new MyObject();

        Thread t1 = new Thread(new Runnable() {
            public void run() {
                myObject.method();
            }
        }, "t1");

        Thread t2 = new Thread(new Runnable() {
            public void run() {
                myObject.method();
            }
        }, "t2");

        t1.start();
        t2.start();
    }
}
