package com.samples.throttling;

import java.util.LinkedList;

@SuppressWarnings("serial")
public class RequestQueue extends LinkedList<Long> {
	
	private String ipAddress;
	private final int threshold;
	
	public RequestQueue(String ip) {
		this.ipAddress = ip;
		this.threshold = 100;
	}
	
	public String getIpAddress() {
		return this.ipAddress;
	}
	
	public int getThreshold() {
		return this.threshold;
	}
	
	public void addRequest() {		
		while(!this.isEmpty()) {			
			if (System.currentTimeMillis() - 3600 * 1000 > this.peek()) {
				this.poll();
			} else {
				break;
			}
		}
		
		this.offer(System.currentTimeMillis());
	}
	
	public boolean isThrottle() {
		if (this.size() > this.threshold) {
			return true;
		} else {
			return false;
		}
	}
}
