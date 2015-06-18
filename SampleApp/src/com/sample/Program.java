package com.sample;

import com.sample.utils.StringUtils;

public class Program {

	public static void main(String[] args) {
		String input = "Prakash";
		System.out.printf("All chars in %s are %s.", input, StringUtils.HasUniqueCharacters(input) ? "unique" : "not unique");
	}

}
