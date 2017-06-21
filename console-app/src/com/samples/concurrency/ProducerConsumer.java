package com.samples.concurrency;

public class ProducerConsumer {
	
	private static Object lock = new Object();
	
	private static int[] buffer;
	private static int count;
	
	static class Producer {
		void produce() {			
			synchronized (lock) {
				if (isFull(buffer)) {
					try {
						lock.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}	
				
				buffer[count++] = 1;
				lock.notify();
			}
		}
	}
	
	static class Consumer {
		void consume() {
			
			synchronized (lock) {
				if (isEmpty()) {
					try {
						lock.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}		
				
				buffer[--count] = 0;
				lock.notify();
			}	
		}
	}
	
	
	public static int getCount() {
		return count;
	}
	
	public static boolean isFull(int[] buffer) {
		return count == buffer.length;
	}
	
	public static boolean isEmpty() {
		return count == 0;
	}
	
	public static void setBuffer(int num) {
		buffer = new int[num];
	}
	
	public static void setCount(int c) {
		count = c;
	}
}
