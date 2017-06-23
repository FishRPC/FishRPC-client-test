package com.fish.rpc.test.parallel;

import java.util.concurrent.CountDownLatch;

import com.fish.rpc.test.multi.IMulti;

public class MutilParallelRequestThread implements Runnable {

	private CountDownLatch signal;
	private CountDownLatch finish;
	private int taskNumber = 0;
	private IMulti mutil;
	
	public MutilParallelRequestThread(IMulti mutil,CountDownLatch signal,CountDownLatch finish,int taskNumber){
		this.signal = signal;
		this.finish = finish;
		this.taskNumber = taskNumber;
		this.mutil = mutil;
	}
	@Override
	public void run() {
		try {
			signal.await();
			int result = mutil.multi(taskNumber,taskNumber);
			if(result!=taskNumber*taskNumber){
				//throw new RuntimeException();
				System.err.println(String.format("执行结果错误result=%s,realResult=%s", result,(taskNumber*taskNumber)));
			}
			
			finish.countDown();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
