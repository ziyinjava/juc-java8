package com.example.thread.interruption.demo;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @Author: 无双老师【云析学院】
 * @Date: 2019-05-18
 * @Description: 自定义一个任务队列，封装了LinkedBlockingQueue
 */
public class TaskQueue<T> {

    private static final int MAX_TASKS = 1000;

    private BlockingQueue<T> queue = new LinkedBlockingQueue<>(MAX_TASKS);

    /**
     * putTask()可以对中断做出响应
     */
    public void putTask(T t) throws InterruptedException {
        queue.put(t);
    }

    /**
     * getTask()可以对中断做出响应
     */
    public T getTask() throws InterruptedException {
        return queue.take();
    }
}
