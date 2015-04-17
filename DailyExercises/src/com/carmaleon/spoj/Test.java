package com.carmaleon.spoj;

import java.util.Arrays;

public class Test {

	
	public static void main(String[] args) {
		System.out.println(tail("123".toCharArray()));
	}
	
	private static char[] tail(char[] origin) {
		if (origin.length == 1)
			return new char[0];
		else
			return Arrays.copyOfRange(origin, 1, origin.length);
	}
}
