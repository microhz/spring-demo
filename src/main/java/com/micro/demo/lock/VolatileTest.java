package com.micro.demo.lock;
/**
 * @author micro
 * @date 2017年7月20日
 * @description : 
 */

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class VolatileTest {

	private ReadWriteLock readLock = new ReentrantReadWriteLock();
	
	private ReentrantReadWriteLock.WriteLock writeLock = new ReentrantReadWriteLock(true).writeLock();
	
	private int num = 0;
	
	private int a = 1;
	
	public int getA() {
		return a;
	}

	public void setA(int a) {
		this.a = a;
	}
	
	public static void main(String[] args) {
		final VolatileTest volatileTest = new VolatileTest();
		new Thread(() -> {
			try {
				Thread.sleep(1000);
				volatileTest.setA(5);
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}).start();
		new Thread(() -> {
			System.out.println("读取 a " + volatileTest.getA());
			try {
				Thread.sleep(2000);
				System.out.println("读取 a " + volatileTest.getA());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}).start();
	}
	
	public void read() {
		try {
			readLock.readLock().lock();;
			System.out.println(Thread.currentThread().getName() + "读取 num : " + num);
			Thread.sleep(2000);
		} catch (Exception ex) {
			
		} finally {
			readLock.readLock().unlock();
		}
	}
	
	public void write() {
		try {
			readLock.writeLock().lock();
			System.out.println(Thread.currentThread().getName() + "写入 num : " + ++ num);
			Thread.sleep(2000);
		} catch (Exception ex) {
			
		} finally {
			readLock.writeLock().unlock();
		}
	}
}

class MyObj {
	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
}
