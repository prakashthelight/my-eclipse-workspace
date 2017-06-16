package com.samples.utils;

public class MathsUtils {
	
	public int gcd(int a, int b) {
	    if (b > a) {
	        int temp = a;
	        a = b;
	        b = temp;
	    }
	    
	    if (b == 0) {
	        return a;
	    } else if (b == 1) {
	        return 1;
	    } else if ( a % b == 0) {
	        return b;
	    } else if (a == b) {
	        return b;
	    } else {
	        return gcd(a-b, b);    
	    }
    }
}
