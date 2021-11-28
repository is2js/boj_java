package com.company.boj;

import java.io.FileInputStream;
import java.util.Scanner;

class Solution3_10809 {

	public static void main(String args[]) throws Exception {
		//1. python의 string.find -> 인덱스를 반환하며 못찾으면 -1 -> java의 `.indexOf`도 index를 못찾으면 -1을 반환한다.
		//      cf) python의 .index()는 못찾으면 에러발생해서 try catch
		//2. python의 string.ascii_lowercase 대신 -> java는 char 'a'부터 담긴 변수를 +1하면 'b'가 되는 매직이 있다.
		System.setIn(new FileInputStream("src/com/company/boj/input.txt"));
		Scanner sc = new Scanner(System.in);

		String word = sc.nextLine();

		for (char c = 'a'; c <= 'z'; c++) {
			System.out.print(word.indexOf(c) + " ");

		}

	}
}
