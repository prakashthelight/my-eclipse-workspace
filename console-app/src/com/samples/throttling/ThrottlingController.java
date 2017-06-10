package com.samples.throttling;

import java.util.HashMap;

public class ThrottlingController {
	HashMap<String, RequestQueue> counters = new HashMap<>();
	
	public boolean isThrottle(String ip) {
		if(counters.containsKey(ip)) {
			RequestQueue queue = counters.get(ip);
			return queue.isThrottle();
		} else {
			RequestQueue queue = new RequestQueue(ip);
			queue.addRequest();
			return false;
		}
	}
}
