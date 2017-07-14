package com.micro.demo.spring;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author micro
 * @date 2017年7月13日
 * @description : 
 */
public class DateStructureTest {

	/**
	 * 测试Map
	 * @param args
	 */
//	static BlockingQueue<Object> blockingQueue = new ArrayBlockingQueue<>(1);// 有界阻塞队列
//	static BlockingQueue<Object> blockingQueue = new LinkedBlockingDeque<>(1);// 有界阻塞队列
//	static BlockingQueue<Object> blockingQueue = new PriorityBlockingQueue<>(1);// 无界阻塞队列
	static BlockingQueue<User> blockingQueue = new DelayQueue<User>();// 延时队列
	public static void main(String[] args) {
		ExecutorService taskExecutor = Executors.newCachedThreadPool();
		taskExecutor.execute(new PutTask());
		taskExecutor.execute(new GetTask());
		taskExecutor.shutdown();
	}
	
	public static class PutTask implements Runnable {

		@Override
		public void run() {
			try {
				for (int i = 0;i < 5;i ++) {
//					Thread.currentThread().sleep(1000);
					String o = "object - " + i;
					User user = new User();
					user.setId(i);
					blockingQueue.offer(user);
					System.out.println(Thread.currentThread().getName() + "放入 " + user);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public static class GetTask implements Runnable {

		@Override
		public void run() {
			while (true) {
				try {
//					Thread.currentThread().sleep(3000);
					Object takeObject = blockingQueue.take();
					System.out.println(Thread.currentThread().getName() + "获取到对象 : " + takeObject);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
	
	// 优先级队列
	public static class User implements Delayed {
		
		private Integer id;
		

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		@Override
		public int compareTo(Delayed o) {
			User u2 = (User) o;
			return u2.getId() > this.id ? 1 : -1;
		}

		@Override
		public long getDelay(TimeUnit unit) {
			return unit.toSeconds(1);
		}

		@Override
		public String toString() {
			return "User [id=" + id + "]";
		}
		
		
		
	}
	
	public static void test(MyInter myInter) {
		myInter.print();
	}
	
	public interface MyInter {
		void print();
	}
}
