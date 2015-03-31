package com.carmaleon.spoj;

import java.util.*;
import java.lang.*;

class Main {
	public static void main(String[] args) {

		class Pair {
			int m = 0;
			int n = 0;

			public Pair(int m, int n) {
				this.m = m;
				this.n = n;
			}
		}

		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();

		if (t < 1 || t > 10) {
			System.out
					.println("Number of test cases in a single line must be between 1 and 10");
			System.exit(1);
		}
		java.util.List<Pair> testCases = new ArrayList<Pair>();

		for (int i = 0; i < t; i++) {
			int m = scan.nextInt();
			int n = scan.nextInt();
			if (m < 1 && m > n) {
				System.out
						.println("First number must be between 1 and second number");
				System.exit(2);
			}

			if (n > 1000000000) {
				System.out
						.println("Second number must be less than 1000000000");
				System.exit(2);
			}

			if (n - m > 100000) {
				System.out
						.println("Distance between numbers must be less than 1000000");
				System.exit(3);
			}
			testCases.add(new Pair(m, n));

		}

		for (Pair tc : testCases) {
			List<Integer> primes = new ArrayList<Integer>();
			for (int i = tc.m; i <= tc.n; i++) {
				if (i == 1)
					continue;
				if (i == 2 || i == 3) {
					primes.add(i);
					continue;
				}
				if (i % 2 == 0)
					continue;// discard composites

				if (isPrime(i))
					primes.add(i);
			}

			for (int p : primes) {
				System.out.println(p);
			}
			if (!primes.isEmpty())
				System.out.println("");
		}

		System.exit(0);
	}

	public static boolean isPrime(long n) {
		if (n <= 3) {
			return n > 1;
		} else if (n % 2 == 0 || n % 3 == 0) {
			return false;
		} else {
			double sqrtN = Math.floor(Math.sqrt(n));
			for (int i = 5; i <= sqrtN; i += 6) {
				if (n % i == 0 || n % (i + 2) == 0) {
					return false;
				}
			}
			return true;
		}
	}

}
