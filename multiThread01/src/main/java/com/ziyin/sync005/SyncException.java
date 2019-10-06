package com.ziyin.sync005;
/**
 * synchronized异常
 * @author alienware
 *
 * 出现异常,锁会释放, 这里就需要考虑整个处理是否有上下关联,
 * 如果中间出错了,有两种策略,一种是上下关联, 中间出错,中断(记录日志,抛出运行时异常),并回滚
 * 如果不是,则catch记录日志即可,等待后续补偿
 */
public class SyncException {

	private int i = 0;
	public synchronized void operation(){
		while(true){
			try {
				i++;
				Thread.sleep(100);
				System.out.println(Thread.currentThread().getName() + " , i = " + i);
				if(i == 20){
					//Integer.parseInt("a");
					throw new RuntimeException();
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		
		final SyncException se = new SyncException();
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				se.operation();
			}
		},"t1");
		t1.start();
	}
	
	
}
