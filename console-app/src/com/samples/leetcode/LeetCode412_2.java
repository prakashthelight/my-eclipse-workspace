package com.samples.leetcode;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * Fizz Buzz - Extended Version <br/>
 * 
 * @author Kumar, Prakash
 *
 */
public class LeetCode412_2 {

	public static void main(String[] args) {
		ArrayList<StringConverter> converters = new ArrayList<>();
		converters.add(new StringConverter(3, "Fizz"));
		converters.add(new StringConverter(2, "Foo"));
		converters.add(new StringConverter(5, "Buzz"));
		FizzBuzz(30, converters);
	}

	public static void FizzBuzz(int n, ArrayList<StringConverter> converters) {

		// sort converters
		converters.sort(new Comparator<StringConverter>() {
			@Override
			public int compare(StringConverter a, StringConverter b) {
				return a.div - b.div;
			}
		});

		for (int i = 1; i <= n; i++) {
			String result = "";
			for (StringConverter c : converters) {
				result += c.getString(i);
			}

			if ("".equals(result)) {
				System.out.println(i);
			} else {
				System.out.println(result);
			}
		}
	}

	public static void FizzBuzz(int n, StringConverter foo, StringConverter bar) {
		for (int i = 1; i <= n; i++) {
			String result = "";
			result += foo.getString(i) + bar.getString(i);
			
			if ("".equals(result)) {
				System.out.println(i);
			} else {
				System.out.println(result);
			}
		}
	}
}

class StringConverter {
	int div;
	String str;

	public StringConverter(int div, String str) {
		this.div = div;
		this.str = str;
	}

	public String getString(int num) {
		if (num % div == 0) {
			return str;
		}

		return "";
	}
}
