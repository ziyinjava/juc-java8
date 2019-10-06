package com.ziyin.coll013;

import java.util.concurrent.SynchronousQueue;


public class UseQueue {

	public static void main(String[] args) throws Exception {
		
		//高性能无阻塞无界队列：ConcurrentLinkedQueue
		/**
		ConcurrentLinkedQueue<String> q = new ConcurrentLinkedQueue<String>();
		q.offer("a");
		q.offer("b");
		q.offer("c");
		q.offer("d");
		q.add("e");
		
		System.out.println(q.poll());	//a 从头部取出元素，并从队列里删除
		System.out.println(q.size());	//4
		System.out.println(q.peek());	//b
		System.out.println(q.size());	//4
		*/
		
		/**
		ArrayBlockingQueue<String> array = new ArrayBlockingQueue<String>(5);
		array.put("a");
		array.put("b");
		array.add("c");
		array.add("d");
		array.add("e");
		array.add("f");
		//System.out.println(array.offer("a", 3, TimeUnit.SECONDS));
		*/


		/*LinkedBlockingQueue queue = new LinkedBlockingQueue(5);
		queue.offer("a");
		queue.offer("b");
		queue.offer("c");
		queue.offer("d");
		queue.offer("e");
		queue.offer("f");
		System.out.println(queue);*/
		

		//阻塞队列
			/*LinkedBlockingQueue<String> q = new LinkedBlockingQueue<String>();
			q.offer("a");
			q.offer("b");
			q.offer("c");
			q.offer("d");
			q.offer("e");
			q.add("f");*/
		//System.out.println(q.size());
		
//		for (Iterator iterator = q.iterator(); iterator.hasNext();) {
//			String string = (String) iterator.next();
//			System.out.println(string);
//		}

//		q.poll();
//		System.out.println(q.size());

//		List<String> list = new ArrayList<String>();
//		System.out.println(q.drainTo(list, 3));
//		System.out.println(list.size());
//		for (String string : list) {
//			System.out.println(string);
//		}
//
//		System.out.println(q.size());
		
		final SynchronousQueue<String> q = new SynchronousQueue<String>();
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					System.out.println(q.take());
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		t1.start();
		Thread t2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				q.add("asdasd");
			}
		});
		t2.start();
	}
}
