package com.micro.demo.spring;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/**
 * @author mapc 
 * @date 2017年6月28日
 * 线程池的demo
 */
public class ExecuteServiceDemo {
	public static void main(String[] args) {
		
		/*// 方法一
		ExecutorService executorService = Executors.newCachedThreadPool();
		CompletionService<String> completionService = new ExecutorCompletionService(executorService);
		ExecuteServiceDemo executeServiceDemo = new ExecuteServiceDemo();
		// 十个
		long startTime = System.currentTimeMillis();
		int count = 0;
		for (int i = 0;i < 10;i ++) {
			count ++;
			GetContentTask getContentTask = new ExecuteServiceDemo.GetContentTask("micro" + i, 10);
			completionService.submit(getContentTask);
		}
		System.out.println("提交完任务，主线程空闲了, 可以去做一些事情。");
		// 假装做了8秒种其他事情
		try {
			Thread.sleep(8000);
			System.out.println("主线程做完了，等待结果");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		try {
			// 做完事情要结果
			for (int i = 0;i < count;i ++) {
				Future<String> result = completionService.take();
				System.out.println(result.get());
			}
			long endTime = System.currentTimeMillis();
			System.out.println("耗时 : " + (endTime - startTime) / 1000);
		}  catch (Exception ex) {
			System.out.println(ex.getMessage());
		}*/
		
		/*// 方法二
		ExecutorService executeService = Executors.newCachedThreadPool();
		List<GetContentTask> taskList = new ArrayList<GetContentTask>();
		long startTime = System.currentTimeMillis();
		for (int i = 0;i < 10;i ++) {
			taskList.add(new GetContentTask("micro" + i, 10));
		}
		try {
			System.out.println("主线程发起异步任务请求");
			List<Future<String>> resultList = executeService.invokeAll(taskList);
			// 这里会阻塞等待resultList获取到所有异步执行的结果才会执行 
			for (Future<String> future : resultList) {
				System.out.println(future.get());
			}
			// 主线程假装很忙执行8秒钟
			Thread.sleep(8);
			long endTime = System.currentTimeMillis();
			System.out.println("耗时 : " + (endTime - startTime) / 1000);
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		
		
		/*ExecutorService executorService = Executors.newCachedThreadPool();
		ArrayList<GetContentTask> taskList = new ArrayList<GetContentTask>();
		taskList.add(new GetContentTask("micro1",3));
		taskList.add(new GetContentTask("micro2", 6));
		try {
			List<Future<String>> resultList = executorService.invokeAll(taskList);// 等待6秒 
//			String result2 = executorService.invokeAny(taskList); // 等待3秒
			// invokeAll 提交一堆任务并行处理并拿到结果
			// invokeAny就是提交一堆并行任务拿到一个结果即可
			for (Future<String> result : resultList) {
				System.out.println(result.get());
			}
//			System.out.println(result2);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("主线程等待");*/
		
		try {
			ExecutorService executorService = Executors.newCachedThreadPool();
			List<Callable<String>> taskList = new ArrayList<Callable<String>>();
			taskList.add(new GetContentTask("micro1", 4));
			taskList.add(new GetContentTask("micro2", 6));
			// 等待五秒
			List<Future<String>> resultList = executorService.invokeAll(taskList, 5, TimeUnit.SECONDS);
			for (Future<String> future : resultList) {
				System.out.println(future);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
	}
	
	private static class GetContentTask implements Callable<String> {
		
		private String name;
		
		private Integer sleepTimes;
		
		public GetContentTask(String name, Integer sleepTimes) {
			this.name = name;
			this.sleepTimes = sleepTimes;
		}
		public String call() throws Exception {
			// 假设这是一个比较耗时的操作
			Thread.sleep(sleepTimes * 1000);
			return "this is content : hello " + this.name;
		}
		
	}
}
