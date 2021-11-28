package com.company.boj;

import java.io.FileInputStream;
import java.util.Scanner;

class Solution4_1110 {
	// 1. while () 조건절에 바로 못넣는 상황이라면, 내부 업데이트 직후 바로 if:break검사순으로 넣는다.
	// 2. 2자리수 제한이라면, /10 이 10의자리, %10이 1의자리가 된다.
	// 	 -  만약 여러자리수라면, 10^(n-1)으로 나눈 몫 -> n번째자리를 1의자리로 끌어온 뒤 -> % 10 -> 1의 자리수만 골라내기

	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("src/com/company/boj/input.txt"));
		Scanner sc = new Scanner(System.in);

		int N = Integer.parseInt(sc.nextLine());

		int currentNumber = N;
		int count = 0;

		while (true) {

			count++;

			int firstNumber = currentNumber / 10;
			int secondNumber = currentNumber % 10;
			int middleNumber = firstNumber + secondNumber;
			currentNumber = (secondNumber * 10) + (middleNumber % 10);
			// System.out.println(currentNumber);
			// while if조건절에 못넣으면, 업데이트 직후 검사를 시행하도록 해야. 현 상황을 반영한다.
			if (currentNumber == N) {
				break;
			}
		}

		System.out.println(count);

	}
}
