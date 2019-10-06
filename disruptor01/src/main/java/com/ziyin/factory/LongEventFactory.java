package com.ziyin.factory;

import com.lmax.disruptor.EventFactory;
import com.ziyin.bo.LongEvent;

// EventFactory 实例化LongEvent
public class LongEventFactory implements EventFactory<LongEvent> {

	public LongEvent newInstance() {

		return new LongEvent();
	}

}
