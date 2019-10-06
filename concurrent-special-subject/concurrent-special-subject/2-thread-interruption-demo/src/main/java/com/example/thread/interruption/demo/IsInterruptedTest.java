package com.example.thread.interruption.demo;

/**
 * @Author: 无双老师【云析学院】
 * @Date: 2019-05-18
 * @Description:
 * 1. isInterrupted()检测调用该方法的线程是否被中断，中断状态不会被清除,可以重复调用
 *
 * 2. 线程一旦被中断，该方法返回true
 *
 * 3. 一旦sleep等方法响应中断，抛出中断异常，将清除中断状态，此时方法将返回false。
 */
public class IsInterruptedTest {
    public static void main(String[] args) {
        // 当前线程
        Thread thread = Thread.currentThread();
        // 当前线程是否被中断
        System.out.println("1: " + thread.isInterrupted()); //false
        // 设置线程中断标识
        thread.interrupt();
        // 判断线程是否被中断
        System.out.println("2: " + thread.isInterrupted()); //true
        // 判断线程是否被中断
        System.out.println("3: " + thread.isInterrupted()); //true
        try {
            // 线程休眠
            Thread.sleep(2000); // 如果当前中断标志是true,调用sleep方法会抛出InterruptedException, 中断状态会重置为false
            System.out.println("not interrupted...");
        } catch (Exception e) {
            System.out.println("Thread.sleep interrupted...");
            // 判断线程是否被中断
            System.out.println("4: " + thread.isInterrupted()); //false
        }
        System.out.println("5: " + thread.isInterrupted()); //false
    }
}
