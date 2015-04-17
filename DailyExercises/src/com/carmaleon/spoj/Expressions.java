package com.carmaleon.spoj;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

class Main2 {

	private static List<Character> ops = Arrays.asList('+', '-', '*', '/', '^');
	private static final char start = '(';
	private static final char end = ')';

	public static void main(String[] args) throws java.lang.Exception {

		Scanner scan = new Scanner(System.in);

		try {

			int t = scan.nextInt();
			List<String> rs = new ArrayList<String>();

			for (int i = 0; i < t; i++) {

				String exp = scan.next();
				char[] ca = exp.toCharArray();
				rs.add(eval(ca[0], tail(ca), new Stack<Character>(),
						new StringBuffer()));

			}

			for (String r : rs) {

				System.out.println(r);

			}

		} finally {
			scan.close();
		}
	}

	private static char[] tail(char[] origin) {
		if (origin.length == 1)
			return new char[0];
		else
			return Arrays.copyOfRange(origin, 1, origin.length);
	}

	private static String eval(char curr, char[] rem, Stack<Character> opers,
			StringBuffer exp) {

		if (rem.length == 0) {
			if (curr != end) {
				return exp.append(curr).toString();
			} else {
				return exp.append(opers.pop()).toString();
			}
		}

		if (curr == end) {
			exp.append(opers.pop());
		}

		if (ops.contains(curr)) { // operator detected
			opers.push(curr);
		} else if (curr != start && curr != end) { // term detected
			exp.append(curr);
		}

		return eval(rem[0], tail(rem), opers, exp);

	}

}