package com.micro.demo.spring.threadQueue;

import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.locks.Condition;

/**
 * @author micro
 * @date 2017年8月19日
 * @description :
 */
public class ThreadTest {

	public static void main(String[] args) {
		/*
		 * ExecutorService executor = Executors.newCachedThreadPool();
		 * CompletionService<String> completionService = new
		 * ExecutorCompletionService<>(executor); for (int i = 0; i < 100; i++)
		 * { completionService.submit(new Callable<String>() {
		 * 
		 * @Override public String call() throws Exception {
		 * Thread.currentThread().sleep(1000); return
		 * Thread.currentThread().getName() + "---t"; } }); } try {
		 * Future<String> f = null; while ((f = completionService.take()) !=
		 * null) { try { System.out.println(f.get()); } catch
		 * (ExecutionException e) { e.printStackTrace(); } } } catch
		 * (InterruptedException e) { e.printStackTrace(); }
		 */

		int[] iArray = new int[52];
		for (int i = 0; i < 52; i++) {
			iArray[i] = i + 1;
		}

		String[] sArray = new String[26];
		int start = (int) 'a';
		for (int i = 0; i < 26; i++) {
			sArray[i] = String.valueOf((char) (start + i));
		}

		StringBuilder sb = new StringBuilder();
		new Thread(new NumberPrinter(sb, iArray)).start();
		new Thread(new StringPrinter(sb, sArray)).start();
	}

	/**
	 * 数组A内容为 1,2,3,4...52 ,数组B内容为26个英文字母，使用两个线程分别输入两个数组，
	 * 打印内容为：12a34b56c78e....... 这样的规律
	 */
	public void test1() {

	}

	public static class NumberPrinter implements Runnable {

		private StringBuilder sb;
		private int[] array;

		public NumberPrinter(StringBuilder sb, int[] array) {
			this.sb = sb;
			this.array = array;
		}

		@Override
		public void run() {
			int count = 0;
			for (int i = 0; i < array.length; i++) {
				synchronized (sb) {
					sb.append(array[i]);
					System.out.println(Thread.currentThread().getName() + " print sb ," + sb.toString());
					count++;
					if (count >= 2) {
						// 释放锁
						try {
							sb.notify();
							sb.wait();
							count = 0;
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}

			}
		}
	}

	public static class StringPrinter implements Runnable {

		private StringBuilder sb;
		private String[] array;

		public StringPrinter(StringBuilder sb, String[] array) {
			this.sb = sb;
			this.array = array;
		}

		@Override
		public void run() {
			int count = 0;
			for (int i = 0; i < array.length; i++) {
				synchronized (sb) {
					sb.append(array[i]);
					System.out.println(Thread.currentThread().getName() + " print sb ," + sb.toString());
					count++;
					if (count >= 1) {
						// 释放锁
						try {
							sb.notify();
							sb.wait();
							count = 0;
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}

			}
		}
	}

	/**
	 * 一个文件中有10000个数，用Java实现一个多线程程序将这个10000个数输出到5个不用文件中（不要求输出到每个文件中的数量相同）。
	 * 要求启动10个线程，两两一组，分为5组。每组两个线程分别将文件中的奇数和偶数输出到该组对应的一个文件中，需要偶数线程每打印10个偶数以后，就将奇数线程打印10个奇数，如此交替进行。
	 * 同时需要记录输出进度，每完成1000个数就在控制台中打印当前完成数量，并在所有线程结束后，在控制台打印”Done”.
	 */
	public static class PrintNumToFile implements Runnable {
		private StringBuilder sb; // 原文件
		private Condition condition; // 可以唤醒指定的线程
		private StringBuilder targetSb = new StringBuilder();

		public PrintNumToFile(StringBuilder sb, Condition condition) {
			this.sb = sb;
			this.condition = condition;
		}

		private Integer count = 0;
		@Override
		public void run() {
			Thread t1 = new Thread(new Runnable() {
				
				@Override
				public void run() {
					if (count / 10 % 2 == 1) {
						
					}
				}
			});
		}
	}
}
