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
			long start = System.currentTimeMillis();
			int result = add.add(taskNumber, taskNumber);
			System.out.println("task-"+taskNumber+" add result : ["+result+"],耗时"+(System.currentTimeMillis()-start));
			finish.countDown();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
