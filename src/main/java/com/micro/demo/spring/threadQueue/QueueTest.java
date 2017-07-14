package com.micro.demo.spring.threadQueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author micro
 * @date 2017年7月14日
 * @description : 
 */
public class QueueTest {
	public static void main(String[] args) {
		// 核心2，最大5，5秒失效, 无界队列
		ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 5, 5, TimeUnit.SECONDS, new ArrayBlockingQueue<>(2));
		threadPoolExecutor.setRejectedExecutionHandler((r , threadPool) -> {
			// 拒绝策略
			System.out.println("thread count more than maxsize ... this is reject info");
		});
		for (int i = 0;i < 10;i ++) {
			System.out.println("execute --- index : " + i);
			threadPoolExecutor.execute(new SleepTask());
			System.out.println("current active thread count : " + threadPoolExecutor.getActiveCount());
		}
	}
	
	public static class SleepTask implements Runnable {

		@Override
		public void run() {
			String currentThreadName = Thread.currentThread().getName();
			try {
				System.out.println(currentThreadName + " start to sleep 1 second");
				Thread.sleep(1000);
				System.out.println(currentThreadName + "gets up...");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
}
