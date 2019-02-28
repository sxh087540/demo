package com.sxh;

public class ThreadTest2 extends Thread {

	private String name;

	public ThreadTest2(String name) {
		super(name);
		this.name = name;
	}

	public void run() {
		System.out.println(Thread.currentThread().getName() + " 线程运行开始!");
		for (int i = 0; i < 5; i++) {
			System.out.println("子线程" + name + "运行 : " + i);
			try {
				sleep((int) Math.random() * 10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(Thread.currentThread().getName() + " 线程运行结束!");
	}

	public static void main(String[] args) {
		System.out.println(Thread.currentThread().getName() + "主线程运行开始!");
		ThreadTest2 mTh1 = new ThreadTest2("A");
		ThreadTest2 mTh2 = new ThreadTest2("B");
		mTh1.start();
		mTh2.start();
		try {
			mTh1.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			mTh2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + "主线程运行结束!");

	}

}
