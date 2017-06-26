package com.samples.model;

public class Word {
	String str;
	int frequency;

	public Word(String str) {
		this.str = str;
	}

	public String getWordStr() {
		return this.str;
	}

	public int getFrequency() {
		return this.frequency;
	}
	
	public void setFrequency(int frequency) {
		this.frequency = frequency;
	}
	
	@Override
	public int hashCode() {
		return this.str.hashCode();
	}

	@Override
	public String toString() {
		return super.toString();
	}

	@Override
	public boolean equals(Object obj) {		
		return this.str.equals(((Word)obj).getWordStr());
	}		
}