package com.example.thread.common.method.waitnotify;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author: 无双老师【云析学院】
 * @Date: 2019-06-05
 * @Description:
 */
public class WaitClassDemo {

    private static SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");

    public static void main(String[] args) {
        Object obj = new Object();
        for (int i = 0; i < 5; i++) {
            new WaitThread(i + "", obj).start();
        }
        new NotifyThread(obj).start();
    }

    /**
     * 调用wait()方法的线程
     */
    static class WaitThread extends Thread {

        Object obj;

        public WaitThread(String name, Object obj) {
            setName("WaitThread" + name);
            this.obj = obj;
        }

        @Override
        public void run() {
            synchronized (obj) {
                System.out.println(sdf.format(new Date()) + " " + getName() + " before wait()");
                try {
                    obj.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(sdf.format(new Date()) + " " + getName() + " after wait()");
            }
        }
    }

    /**
     * 调用notify()/notifyAll()
     */
    static class NotifyThread extends Thread {

        Object obj;

        public NotifyThread(Object obj) {
            setName("NotifyThread");
            this.obj = obj;
        }

        @Override
        public void run() {
            synchronized (obj) {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(sdf.format(new Date()) + " NotifyThread before notify()");
                // 唤醒所有线程 用notifyAll()会按照后进先出（LIFO）的原则恢复线程
                obj.notifyAll();
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(sdf.format(new Date()) + " NotifyThread after notify()");
            }
        }
    }
}
