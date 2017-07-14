package com.micro.demo.spring.threadQueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author micro
 * @date 2017年7月14日
 * @description : 
 */
public class BBT {

	public static void main(String[] args) throws Exception{
		BlockingQueue<Runnable> queue = new ArrayBlockingQueue<Runnable>(1);
		final ThreadPoolExecutor executor = new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MINUTES, queue,new ThreadPoolExecutor.CallerRunsPolicy());
		
		for(int i=0;i<100;i++){
//			new Thread(()->{
				executor.execute(new Runnable() {
					@Override
					public void run() {
						System.out.println(Thread.currentThread().getName() + "我要启动了。。。。");
						try {
							Thread.sleep(3000L);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				});
//				}).start();
		}
	}
}
