package com.fish.rpc.test.parallel;

import java.util.concurrent.CountDownLatch;

import com.fish.rpc.test.add.IAdd;

public class AddParallelRequestThread implements Runnable {

	private CountDownLatch signal;
	private CountDownLatch finish;
	private int taskNumber = 0;
	private IAdd add;

	public AddParallelRequestThread(IAdd add,CountDownLatch signal,CountDownLatch finish,int taskNumber){
		this.signal = signal;
		this.finish = finish;
		this.taskNumber = taskNumber;
		this.add = add;
	}
	@Override
	public void run() {
		try {
			signal.await();
			int result = add.add(taskNumber,taskNumber);
			if(result!=taskNumber*2){
				System.err.println(String.format("执行结果错误result=%s,realResult=%s", result,(taskNumber+taskNumber)));
			}
 			finish.countDown();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
