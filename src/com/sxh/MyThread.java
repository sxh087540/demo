package com.sxh;
/*
 * 在本地(新建 new Thread)-->start(等待JVM的线程调度器分配CPU时间片)-->可运行状态(Runnable)-->运行状态(线程抢占到了CPU的时间片)
 * -->死亡状态
 * -->线程阻塞(sleep、yelid、wait、lock)-->可运行状态-->死亡状态
 * 
 * 为什么要重写run()方法：因为不是类中的所有代码都要被线程执行的，为类区分哪些代码需要被线程执行，java提供类Thread类中的run()方法
 * 来包含那些要被线程执行的代码
 * 
 * 调用run()方法为什么是单线程的：因为run()方法直接调用相当于普通方法的调用，所以你看到的是单线程的效果，如果要看到多线程的效果
 *必须使用start()方法
 *run()和start()的区别：
 *run():仅仅是封装被执行的代码，直接调用是普通方法
 *start():首先启动来线程，然后再由JVM去调用该线程的run()方法
 *
 *优先级：是提高当前线程的执行几率，并不能保证线程就是第一时间执行
 * 
 */
public class MyThread extends Thread{
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
			for(int i=0;i<100;i++) {
				String ThreadName=Thread.currentThread().getName();
				System.out.println(ThreadName+":"+i);		
		}
	}
		
	public static void main(String[] args) {
		MyThread mt=new MyThread();
		mt.start();
		MyThread mt1=new MyThread();
		mt1.start();
	
	}
}


