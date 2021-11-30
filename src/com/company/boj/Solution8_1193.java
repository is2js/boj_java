package com.company.boj;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

class Solution8_1193 {

	public static final String SPLIT_VALUE = "";

	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("src/com/company/boj/input.txt"));
		Scanner sc = new Scanner(System.in);

		int N = Arrays.stream(sc.nextLine().split(""))
			.mapToInt(Integer::parseInt)
			.boxed()
			.collect(Collectors.toList()).get(0);
		//1
		int cumsum = 0;
		int groupNumber = 0;
		while (cumsum < N) {
			groupNumber++;
			cumsum += groupNumber;
		}
		if (cumsum != N) {
			cumsum -= groupNumber;
		}
		int k = N - cumsum;

		if (!(groupNumber % 2 == 0)) {
			System.out.printf("%d/%d",groupNumber + 1 - k,k );
			System.exit(0);
		}
		System.out.printf("%d/%d",k, groupNumber + 1 - k );

	}

	static List<Integer> convert(String string, String splitValue) {
		return Arrays.stream(string.split(splitValue)).mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());
	}
}
