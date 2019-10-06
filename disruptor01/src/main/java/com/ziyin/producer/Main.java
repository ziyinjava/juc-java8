package com.ziyin.producer;

import com.lmax.disruptor.EventFactory;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.YieldingWaitStrategy;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;
import com.ziyin.bo.LongEvent;
import com.ziyin.consumer.LongEventHandler;
import com.ziyin.factory.LongEventFactory;

import java.nio.ByteBuffer;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

	public static void main(String[] args) {
		// 1.创建可以缓存的线程池，提供发给consumer
		ExecutorService executor = Executors.newCachedThreadPool();
		// 2.创建 Event工厂
		EventFactory<LongEvent> eventFactory = new LongEventFactory();
		// 3.创建ringbuffer大小
		int ringbuffer = 1024 * 1024;// 2的N次方。
		// 4.创建Disruptor
		Disruptor<LongEvent> disruptor = new Disruptor<LongEvent>(eventFactory, ringbuffer, executor,
				ProducerType.MULTI, new YieldingWaitStrategy());
		// 5.连接消费者---注册消费者
		disruptor.handleEventsWith(new LongEventHandler());
		//disruptor.handleEventsWith(new LongEventHandler2());
		// 多个消费者 一个生产者 默认重复消费、配置分组
		// 6.启动
		disruptor.start();
		// 7.创建RingBuffer容器
		RingBuffer<LongEvent> ringBuffer = disruptor.getRingBuffer();
		// 8.创建生产者
		LongEventProducer producer = new LongEventProducer(ringBuffer);
		// 9.指定缓冲区大小
		ByteBuffer byteBuffer = ByteBuffer.allocate(8);
		for (int i = 1; i < 100; i++) {
			byteBuffer.putLong(0, i);
			producer.onData(byteBuffer);
		}
		executor.shutdown();
		disruptor.shutdown();
		
	}

}
