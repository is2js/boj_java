package com.company.boj;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

class Solution9_2869 {

	public static final String SPLIT_VALUE = "";

	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("src/com/company/boj/input.txt"));
		Scanner sc = new Scanner(System.in);

		List<Integer> list = convert(sc.nextLine(), " ");
		Integer A = list.get(0);
		Integer B = list.get(1);
		Integer V = list.get(2);

		int result = A;
		int days = 1;
		while (result < V) {
			days++;
			result = result + (A - B);
		}
		System.out.println(days);

	}

	static List<Integer> convert(String string, String splitValue) {
		return Arrays.stream(string.split(splitValue)).mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());
	}
}
