package com.samples.designpatterns;

public class SingletonLogger {

	private static final Object lock = new Object();
	private static SingletonLogger instance;

	private SingletonLogger() {

	}

	public static SingletonLogger getInstance() {
		synchronized (lock) {
			if (instance == null) {
				instance = new SingletonLogger();
			}
		}

		return instance;
	}

	public void log(String str) {
		System.out.println(str);
	}
}
