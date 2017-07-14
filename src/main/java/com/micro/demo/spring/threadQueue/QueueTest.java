package com.micro.demo.spring.threadQueue;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.SynchronousQueue;
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
		/*final BlockingQueue<Object> blockingQueue = new ArrayBlockingQueue<>(2);
		new Thread(new GetTask(blockingQueue)).start();
		new Thread(new PutTask(blockingQueue)).start();*/
		
		
		/**
		 *  ArrayBlockingQueue ：由数组结构组成的有界阻塞队列。
			LinkedBlockingQueue ：由链表结构组成的有界阻塞队列。
			PriorityBlockingQueue ：支持优先级排序的无界阻塞队列。
			DelayQueue：使用优先级队列实现的无界阻塞队列。
			SynchronousQueue：不存储元素的阻塞队列。
			LinkedTransferQueue：由链表结构组成的无界阻塞队列。
			LinkedBlockingDeque：由链表结构组成的双向阻塞队列。
		 */
		// jdk7 主要提供了以上的阻塞队列
		
		
		//  测试priorityBlockingQueue
		/*BlockingQueue<User> blockingQueue = new PriorityBlockingQueue<User>();
		// 去拿最小id的user执行
		new Thread(new PutTask(blockingQueue)).start();
		new Thread(new GetTask(blockingQueue)).start();*/
		
		// 测试 DelayQueue 延迟被执行，没超过delay设置的时间将不会被放到队列头里，返回null
		
		/*BlockingQueue<DelayTask> blockingQueue = new DelayQueue<DelayTask>();
		new Thread(new PutTask(blockingQueue)).start();
		new Thread(new GetTask(blockingQueue)).start();*/
		
		// 不存储元素的队列
		BlockingQueue<Object> blockingQueue = new SynchronousQueue<>(); 
		new Thread(new PutTask(blockingQueue)).start();
		new Thread(new GetTask(blockingQueue)).start();
	}
	
	// Delayed实现了比较接口 获得优先级支持
	static class DelayTask implements Delayed {
		
		private Integer id;
		
		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		@Override
		public int compareTo(Delayed o) {
			// 两个具有Delayed能力的对象如果同时能够被获取的优先级
			if (o instanceof DelayTask) {
				DelayTask dt = (DelayTask) o;
				return this.id > dt.getId() ? 1 : -1;
			}
			return 0;
		}

		@Override
		public long getDelay(TimeUnit unit) {
			// 延迟放入到队列头部的时间
			return unit.toSeconds(3);
		}

		@Override
		public String toString() {
			return "DelayTask [id=" + id + "]";
		}
	}
	
	public static class User implements Comparable<User> {
		private Integer id;
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		@Override
		public int compareTo(User o) {
			// 按照用户id来排序优先级
			return this.id > o.getId() ? 1 : -1;
		}
		@Override
		public String toString() {
			return "User [id=" + id + "]";
		}
		
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
				System.out.println("-----------");
				try {
					System.out.println(curName + " start to get..");
					Thread.sleep(3000);
					Object o = blockingQueue.take();
//					Object o = blockingQueue.poll(); // 可以去拿，拿不到也不阻塞
					System.out.println(curName + "got a o : " + o);
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
			Random r = new Random();
			while (true) {
				System.out.println("-----------");
				try {
					System.out.println(curName + " start to put..");
					Thread.sleep(1000); // 
					/*User user = new User();
					user.setId(r.nextInt(1000));*/
					/*DelayTask dt = new DelayTask();
					dt.setId(r.nextInt(1000));*/
					blockingQueue.put(new Object());
//					boolean isPut = blockingQueue.offer(new Object());  // 可以去放，放不进去也不阻塞 ,可以通过设置拿和取的时间验证
					System.out.println(curName + "had put o , queue : " + blockingQueue);
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
