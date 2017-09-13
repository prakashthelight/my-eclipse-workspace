package com.samples.designpatterns;

public class SingletonSolution {

	public static void main(String[] args) {
		SingletonLogger logger = SingletonLogger.getInstance();
		logger.log("Some message");
	}

}
