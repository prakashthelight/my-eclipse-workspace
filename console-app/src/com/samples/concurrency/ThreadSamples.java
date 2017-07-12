package com.samples.concurrency;

import com.samples.concurrency.ProducerConsumer.Consumer;
import com.samples.concurrency.ProducerConsumer.Producer;

public class ThreadSamples {
	
	public static void createSampleThread() {
		
		// create an instance of Runnable
		Runnable runnable = () -> {
			System.out.println("I am running in " + Thread.currentThread().getName());
		};

		// create an instance of Thread with task as parameter
		Thread thread = new Thread(runnable);
		thread.setName("My Thread");
		
		// launch thread
		thread.start();
	}
	
	public static void createRaceCondition() throws InterruptedException {
		LongWrapper wrapper = new LongWrapper(0L);		
		Runnable r = () -> {			
			for (int i = 0; i < 1_000; i++) {
				wrapper.incrementValue();
			}
		};
		
		Thread[] threads = new Thread[1_000];		
		for (int i = 0; i < threads.length; i++) {
			threads[i] = new Thread(r);
			threads[i].start();
		}	
		
		for (int i = 0; i < threads.length; i++) {
			threads[i].join();
		}
		
		System.out.println(wrapper.getValue());	
	}
	
	public static void createDeadLock() throws InterruptedException {
		Sample sample = new Sample();
		
		Runnable r1 = () -> {
			sample.methodA();			
		};		
		
		Runnable r2 = () -> {
			sample.methodB();
		};
		
		Thread t1 = new Thread(r1);
		t1.start();
		
		Thread t2 = new Thread(r2);
		t2.start();
		
		t1.join();
		t2.join();
	}
	
	public static void consumerProducerSample() throws InterruptedException {
		ProducerConsumer.setBuffer(10);
		ProducerConsumer.setCount(0);
		
		
		Consumer consumer = new Consumer();
		Producer producer = new Producer();
		
		Runnable consumeTask = () -> {
			for (int i = 0; i < 50; i++) {
				consumer.consume();
			}
			
			System.out.println("Done consuming");
			
		};
		
		Runnable produceTask = () -> {
			for (int i = 0; i < 50; i++) {
				producer.produce();
			}
			
			System.out.println("Done producing");
		};
		
		Thread consumerThread = new Thread(consumeTask);
		Thread producerThread = new Thread(produceTask);
		
		producerThread.start();
		consumerThread.start();	
		
		consumerThread.join();
		producerThread.join();
		
		System.out.println("Data in the bugger: " + ProducerConsumer.getCount());
	}

}
