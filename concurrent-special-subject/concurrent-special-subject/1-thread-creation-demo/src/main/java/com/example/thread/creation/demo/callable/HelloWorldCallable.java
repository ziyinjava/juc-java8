package com.example.thread.creation.demo.callable;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @Author: 无双老师【云析学院】
 * @Date: 2019-05-13
 * @Description: Callable接口创建线程
 */
public class HelloWorldCallable  {
    public static void main(String[] args) {
        // FutureTask对象
        // Lambda表达式
        FutureTask task = new FutureTask(() -> {
            int count = 0;
            for (int i = 0; i <= 100; i++) {
                count += i;
            }
            return count;
        });
        // 创建线程
        Thread thread = new Thread(task);
        // 启动线程
        thread.start();
        try {
            // 获取线程返回值
            System.out.println("1 + 2 + 3 + ... + 100 = " + task.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
