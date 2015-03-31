package com.carmaleon.spoj;

import java.util.Scanner;

public class Life {

	public static void main(String[] args) {
		int curr = -1;
		Scanner sc = new Scanner(System.in);
		while (curr != 42){
			if(curr != -1) System.out.println(curr);
			curr = sc.nextInt();
		}

	}

}
