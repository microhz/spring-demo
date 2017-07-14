package com.micro.demo.spring.threadQueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
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
		// ----------  测试ArrayBlockingQueue阻塞队列和LinkedBlockingQueue队列
		// 核心2，最大5，5秒失效, 无界队列
		/*ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 5, 5, TimeUnit.SECONDS, new ArrayBlockingQueue<>(2));
		threadPoolExecutor.setRejectedExecutionHandler((r , threadPool) -> {
			// 拒绝策略
			System.out.println("thread count more than maxsize ... this is reject info");
		});
		for (int i = 0;i < 10;i ++) {
			System.out.println("execute --- index : " + i);
			threadPoolExecutor.execute(new SleepTask());
			System.out.println("current active thread count : " + threadPoolExecutor.getActiveCount());
		}*/
		
		
		
		// ----- offer与put的测试
		// 阻塞就是放进去或则取出来的过程是阻塞
		// offer可以放进队列（可以指定时间，如果没放进去返回false,放进去true）, put为阻塞
		final BlockingQueue<Object> blockingQueue = new ArrayBlockingQueue<>(2);
		new Thread(new GetTask(blockingQueue)).start();
		new Thread(new PutTask(blockingQueue)).start();
	}
	
	// --- 模拟阻塞队列的拿线程
	public static class GetTask implements Runnable {
		BlockingQueue<Object> blockingQueue;
		public GetTask(BlockingQueue<Object> blockingQueue) {
			this.blockingQueue = blockingQueue;
		}
		@Override
		public void run() {
			String curName = Thread.currentThread().getName();
			while (true) {
				// 每秒拿一个
				System.out.println("-----------");
				try {
					System.out.println(curName + " start to get..");
					Thread.sleep(1000);
//					Object o = blockingQueue.take();
					Object o = blockingQueue.poll(); // 可以去拿，拿不到也不阻塞
					System.out.println(curName + "got a object : o " + o);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
		}
	}
	
	// --- 模拟阻塞线程的放线程
	public static class PutTask implements Runnable {
		BlockingQueue<Object> blockingQueue;
		public PutTask(BlockingQueue<Object> blockingQueue) {
			this.blockingQueue = blockingQueue;
		}
		@Override
		public void run() {
			String curName = Thread.currentThread().getName();
			while (true) {
				// 每0.5放一个
				System.out.println("-----------");
				try {
					System.out.println(curName + " start to put..");
					Thread.sleep(500);
//					blockingQueue.put(new Object());
					boolean isPut = blockingQueue.offer(new Object());  // 可以去放，放不进去也不阻塞 ,可以通过设置拿和取的时间验证
					System.out.println(curName + "had put : " + isPut);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
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
