package com.samples;

import java.util.LinkedList;
import java.util.List;

/**
 * Sample Program
 * 
 * @author Kumar, Prakash
 *
 */
public class Program {
	public static void main(String[] args) {
		
		
		List<String> list = new LinkedList<String>();
		list.add("Prakash");
		
		for (String string : list) {
			System.out.println(string);
		}
	}
}