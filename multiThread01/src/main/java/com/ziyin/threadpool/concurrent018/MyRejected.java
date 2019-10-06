package com.ziyin.threadpool.concurrent018;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

public class MyRejected implements RejectedExecutionHandler{

	
	public MyRejected(){
	}

	/**
	 * 自定义拒绝策略,记录任务信息日志入库,使用定时任务扫描重试, 或者告知发送端,过段时间重发,
	 * 有空间的时候就把执行队列设置大点
	 * @param r
	 * @param executor
	 */
	@Override
	public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
		System.out.println("自定义处理..");
		System.out.println("当前被拒绝任务为：" + r.toString());
		

	}

}
