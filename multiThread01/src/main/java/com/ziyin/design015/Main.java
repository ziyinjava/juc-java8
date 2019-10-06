package com.ziyin.design015;

import java.util.Random;

public class Main {

	public static void main(String[] args) {
		
		Master master = new Master(new Worker(), Runtime.getRuntime().availableProcessors());
		
		Random r = new Random();
		for(int i = 1; i <= 100; i++){
			Task t = new Task();
			t.setId(i);
			t.setPrice(r.nextInt(1000));
			master.submit(t);
		}
		master.execute();
		long start = System.currentTimeMillis();
		
		while(true){
			if(master.isComplete()){
				// 一个线程耗时0.5s有100个任务耗时50s, 假设有10个并发线程, 所以耗时50/10=5s
				long end = System.currentTimeMillis() - start;
				int priceResult = master.getResult();
				System.out.println("最终结果：" + priceResult + ", 执行时间：" + end);
				break;
			}
		}
		
	}
}
