package com.example.thread.priority.demo.daemon;

/**
 * @Author: 无双老师【云析学院】
 * @Date: 2019-06-03
 * @Description:    守护线程
 */
public class MyDaemon implements Runnable {
    @Override
    public void run() {
        for (long i = 0; i < 9999999; i++) {
            System.out.println("守护线程第" + i + "次执行！");
            try {
                Thread.sleep(10);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
