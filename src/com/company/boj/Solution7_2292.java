package com.company.boj;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

class Solution7_2292 {

	public static final String SPLIT_VALUE = "";

	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("src/com/company/boj/input.txt"));
		Scanner sc = new Scanner(System.in);

		int N = Integer.parseInt(sc.nextLine());
		//1 / 2~7/ 8~19
		// 1  6개   12개 /...
		int step = 1;
		int cumsum = 1;

		while (true) {
			step++;
			cumsum += 6 * (step - 1);
			if (cumsum >= N) {
				break;
			}
		}
		if (cumsum == N) {
			System.out.println(step);

		} else {
			System.out.println((step--));
		}

	}

	static List<Integer> convert(String string, String splitValue) {
		return Arrays.stream(string.split(splitValue)).mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());
	}
}
