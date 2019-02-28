package com.sxh;

public class ThreadTest implements Runnable {
	private String name;
	private Object pre;
	private Object self;
	
	private ThreadTest(String name,Object pre,Object self) {
		this.name = name;
		this.pre = pre;
		this.self = self;
	}
	public void run() {
		int count = 14;
		while(count>0) {
			synchronized (pre) {
				synchronized (self) {
					System.out.print(name);
					count--;
					self.notify();
				}
				try {
					pre.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
	}
	
	public static void main(String[] args) throws Exception {
		Object a = new Object();
		Object b = new Object();
		Object c = new Object();
		
		ThreadTest t1 = new ThreadTest("A", c, a);
		ThreadTest t2 = new ThreadTest("B", a, b);
		ThreadTest t3 = new ThreadTest("C", b, c);
		
		new Thread(t1).start();
		Thread.sleep(100);
		new Thread(t2).start();
		Thread.sleep(100);
		new Thread(t3).start();
		Thread.sleep(100);
		
	}
}
