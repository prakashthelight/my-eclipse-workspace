package com.samples.concurrency;

public class Singleton {

	private static final Object lock = new Object();	
	private static Singleton instance;

	private Singleton() {
	}

	public static Singleton getInstance() {
		synchronized(lock) {
			if (instance == null) {
				instance = new Singleton();
			}
		}
		
		return instance;
	}
}
