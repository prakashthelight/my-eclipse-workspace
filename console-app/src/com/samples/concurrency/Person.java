package com.samples.concurrency;

public class Person {	
	private String name;
	private int age;
	
	public synchronized String getName() {
		return name;
	}
	
	public synchronized void setName(String name) {
		this.name = name;
	}
	
	public synchronized int getAge() {
		return age;
	}
	
	public synchronized void setAge(int age) {
		this.age = age;
	}
}
