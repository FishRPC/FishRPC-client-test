package com.fish.rpc.test.parallel;

import java.util.concurrent.CountDownLatch;

import org.apache.commons.lang3.time.StopWatch;

import com.fish.rpc.core.client.FishRPCExecutorClient;
import com.fish.rpc.test.add.IAdd;
import com.fish.rpc.test.multi.IMulti;

public class TestFishRPCParalle {
	
	public static void parallelAddCalcTask(IAdd add, int parallel) throws InterruptedException {
        //开始计时
        StopWatch sw = new StopWatch();
        sw.start();

        CountDownLatch signal = new CountDownLatch(1);
        CountDownLatch finish = new CountDownLatch(parallel);

        for (int index = 1; index < parallel+1; index++) {
        	AddParallelRequestThread client = new AddParallelRequestThread(add, signal, finish, index);
            new Thread(client).start();
        }

        signal.countDown();
        System.out.println("开始并行执行 add...");
        finish.await();
        sw.stop();

        String tip = String.format("加法计算RPC调用总共耗时: [%s] 毫秒", sw.getTime());
        System.out.println(tip);
    }

    public static void parallelMultiCalcTask(IMulti multi, int parallel) throws InterruptedException {
        //开始计时
        StopWatch sw = new StopWatch();
        sw.start();

        CountDownLatch signal = new CountDownLatch(1);
        CountDownLatch finish = new CountDownLatch(parallel);

        for (int index = 0; index < parallel; index++) {
        	MutilParallelRequestThread client = new MutilParallelRequestThread(multi, signal, finish, index);
            new Thread(client).start();
        }

        signal.countDown();
        System.out.println("开始并行执行 mutil...");
        finish.await();
        sw.stop();

        String tip = String.format("乘法计算RPC调用总共耗时: [%s] 毫秒", sw.getTime());
        System.out.println(tip);
    }
    
    public static void main(String[] args) throws Exception {
        //并行度1000
        int parallel = 500; 
        for (int i = 0; i < 100 ; i++) {
    		IAdd add = (IAdd)FishRPCExecutorClient.getInstance().getBean(IAdd.class);
    		parallelAddCalcTask(add,parallel);
    		IMulti multi = (IMulti)FishRPCExecutorClient.getInstance().getBean(IMulti.class);
    		parallelMultiCalcTask(multi,parallel);
            System.out.printf("FishRPC Server 消息协议序列化第[%d]轮并发验证结束!\n\n", i);
            Thread.sleep(5000);
        } 
    }

}
