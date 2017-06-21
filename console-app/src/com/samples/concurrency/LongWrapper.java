package com.samples.concurrency;

public class LongWrapper {
	
	private final Object obj = new Object();
	
	private long l;
	
	public LongWrapper (long l) {
		this.l = l;
	}
	
	public long getValue() {
		return l;		
	}
	
	public void incrementValue() {
		synchronized (obj) {
			l = l + 1;
		}		
	}
}
