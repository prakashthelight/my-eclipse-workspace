package com.samples.concurrency;

public class LongWrapper {
		
	private final Object lock = new Object();
	
	private long l;
	
	public LongWrapper (long l) {
		this.l = l;
	}
	
	public long getValue() {
		return l;		
	}
	
	public void incrementValue() {
		synchronized(lock) {
			l = l + 1;
		}		
	}
}
