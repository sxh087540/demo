package com.sxh;
/*
 * Runnable和Thread创建线程方式的区别
 * 1、runnable很方便的实现全局变量的资源共享(可能出现线程安全问题)
 * 2、一个类只能继承一个类，一个类可以实现多个接口
 * 		一般java中创建线程的方式都是实现Runnable接口
 * 
 * 解决线程安全问题：
 *  1、保证数据的原子性
 *  2、加锁
 */
public class MyRunnable implements Runnable {
	int count = 100;//共享变量
	@Override
	public void run() {
		// TODO Auto-generated method stub
		synchronized (this) {
			while(count>0) {
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				System.out.println(Thread.currentThread().getName()+":"+count--);
			}
		}
		
	}
	
	public static void main(String[] args) {
		//创建线程类，代理对象(静态代理)
		MyRunnable mr = new MyRunnable();
		
		Thread t1 = new Thread(mr);
		Thread t2 = new Thread(mr);
		
		
		t1.start();
		t2.start();
	}
	 
}
