package com.company.codeup;

import java.io.FileInputStream;
import java.util.Scanner;

class Solution {
	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("src/com/company/codeup/input.txt"));
		Scanner sc = new Scanner(System.in);

		// 1-1. split " " -> string[] 배열
		// String[] splitedArr = sc.nextLine().split(" ");
		// 1-2. string[]배열 -> parseInt2개정도만
		// int x = Integer.parseInt(splitedArr[0]);
		// int y = Integer.parseInt(splitedArr[1]);

		// 2. stream split -> arr-> map 메서드참조 parseInt해서 -> list -> arraylist
		//         ArrayList<Integer> arr = (ArrayList<Integer>) Arrays.stream(sc.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
		// 3. 1차원 반복문
		int T = Integer.parseInt(sc.nextLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			System.out.println("test");
		}

		//4. 2차원 배열 받기
		final int N = 10;
		final int M = 10;
		String[][] arr = new String[N][M];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextLine().split(" ");
		}

	}
}
