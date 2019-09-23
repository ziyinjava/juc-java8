package com.ziyin.juc;

/**
 * @author ziyin
 * @create 2019-08-21 23:56
 */
class Message {
	private String title;
	private String info;
	// flag=true 表示可以生产, 但不可以消费
	// flag=false 表示可以消费, 但不可以生产
	private boolean flag = true;


	public String getTitle() {
		return title;
	}

	public synchronized void set(String title,String info) {
		if (flag == false) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		this.title = title;
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		this.info = info;
		flag = false;
		notify();
	}

	public synchronized void get() {
		if (flag == true) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("title " + title + " info " + info);
		flag = true;
		notify();

	}

}

class Producer implements Runnable {
	private Message message;

	public Producer(Message message) {
		this.message = message;
	}

	@Override
	public void run() {
		for (int i = 0; i < 50; i++) {
			if (i % 2 == 0) {
				this.message.set("熊大","牛逼");
			} else {
				this.message.set("熊二分","good");
			}
		}
	}
}

class Consumer implements Runnable {

	private Message message;

	public Consumer(Message message) {
		this.message = message;
	}

	@Override
	public void run() {

		for (int i = 0; i < 50; i++) {
			message.get();
		}
	}
}
public class ProducerAndConsumer {
	public static void main(String[] args) {
		Message message = new Message();
		Producer producer = new Producer(message);
		Consumer consumer = new Consumer(message);
		new Thread(producer).start();
		new Thread(consumer).start();
	}
}
