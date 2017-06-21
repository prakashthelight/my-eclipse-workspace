package com.samples.concurrency;

public class Sample {
	
	private Object key1 = new Object();
	private Object key2 = new Object();
	
	public void methodA() {
		synchronized (key1) {
			System.out.println("[" + Thread.currentThread().getName()+ "] I am in methodA()");
			methodB();
		}
	}
	
	public void methodB() {
		synchronized (key2) {
			System.out.println("[" + Thread.currentThread().getName()+ "] I am in methodB()");
			methodC();
		}
	}
	
	public void methodC() {
		synchronized (key1) {
			System.out.println("[" + Thread.currentThread().getName()+ "] I am in methodC()");			
		}
	}

}
