package com.company.boj;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Solution6_1712 {

	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("src/com/company/boj/input.txt"));
		Scanner sc = new Scanner(System.in);
		List<Integer> arr = new ArrayList<>();
		for (String arg : sc.nextLine().split(" ")) {
			arr.add(Integer.valueOf(arg));
		}
		int fixedExpense = arr.get(0);
		int changedExpense = arr.get(1);
		int profit = arr.get(2);
		double breakEvenPoint = (double)fixedExpense / (double)(profit - changedExpense);
		if (!(breakEvenPoint == (double)(fixedExpense / (profit - changedExpense)))) {
			breakEvenPoint += 1;
		}
		;
		if (breakEvenPoint <= 0) {
			System.out.println(-1);
			System.exit(0);
		}
		System.out.println(breakEvenPoint);

	}
}
