package com.ziyin.consumer;

import com.lmax.disruptor.EventHandler;
import com.ziyin.bo.LongEvent;

//消费者获取生产推送数据
public class LongEventHandler implements EventHandler<LongEvent> {

	public void onEvent(LongEvent event, long sequence, boolean endOfBatch) throws Exception {
		System.out.println("消费者1 获取生产者数据..event:" + event.getValue());
	}

}
