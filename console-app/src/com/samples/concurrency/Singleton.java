package com.samples.concurrency;

public class Singleton {

	private static Singleton instance;
	
	private Singleton() {
		
	}
	
	/**
	 * static method synchronized uses class object as lock and instance methods synchronized uses instance objects as locks
	 * @return
	 */
	public static synchronized Singleton getInstance() {
		
		Object lock = new Object();		
		synchronized (lock) {
			// code block synchronized using lock object
		}
		
		if (instance == null) {
			instance = new Singleton();
		}		
		return instance;
	}
}
