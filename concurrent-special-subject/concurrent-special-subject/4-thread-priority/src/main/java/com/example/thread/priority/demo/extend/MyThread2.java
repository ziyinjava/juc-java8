package com.example.thread.priority.demo.extend;

/**
 * @Author: 无双老师【云析学院】
 * @Date: 2019-05-29
 * @Description:
 */
public class MyThread2 extends Thread {
    @Override
    public void run() {
        super.run();
        System.out.println("MyThread2 Priority = " + this.getPriority());
    }
}
