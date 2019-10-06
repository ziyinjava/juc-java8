package com.example.thread.volatiledemo;

/**
 * @Author: 无双老师【云析学院】
 * @Date: 2019-07-21 19:23
 * @Description: volatile非原子性测试
 */
public class NotAtomicTest {
    public volatile int inc = 0;

    public void increase() {
        // inc = inc + 1;
        inc++;
    }

    public static void main(String[] args) throws InterruptedException {
        final NotAtomicTest test = new NotAtomicTest();
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    test.increase();
                }
            }).start();
        }

        Thread.sleep(3000);
        System.out.println(test.inc);
    }
}
