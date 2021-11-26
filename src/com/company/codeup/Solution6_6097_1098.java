package com.company.codeup;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

class Solution6_6097_1098 {
	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("src/com/company/codeup/input.txt"));
		Scanner sc = new Scanner(System.in);

		// 1-1. split " " -> string[] 배열
		String[] splitedArr = sc.nextLine().split(" ");
		// 1-2. string[]배열 -> parseInt2개정도만
		int h = Integer.parseInt(splitedArr[0]);
		int w = Integer.parseInt(splitedArr[1]);

		int[][] arr = new int[h][w];

		// 2. stream arr-> map 메서드참조 parseInt해서 -> list -> arraylist
		//         ArrayList<Integer> arr = (ArrayList<Integer>) Arrays.stream(splitedArr).map(Integer::parseInt).collect(Collectors.toList());
		int T = Integer.parseInt(sc.nextLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			ArrayList<Integer> item = (ArrayList<Integer>)Arrays.stream(sc.nextLine().split(" "))
				.map(Integer::parseInt)
				.collect(Collectors.toList());

			int length = item.get(0);
			int direction = item.get(1);
			int x = item.get(2);
			int y = item.get(3);

			// direction == 0 : 가로 -> col(y-1시작, + length길이가 되도록 전진 ->  (y-1)+length index까지.. 0 --2-> 2 )을 돌려줘야한다.
			if (direction == 0) {
				for (int j = y - 1; j < (y - 1) + length; j++) {
					try {
						arr[x - 1][j] = 1;
					} catch (IndexOutOfBoundsException e) {
						System.out.println(e);
						// throw new ArrayIndexOutOfBoundsException("격자를 넘어간 막대는 무시됩니다.");
					}
				}
			}
			// 막대의 길이 -> 시작index를 길이의 시작에 포함됨 -> (length-1) index까지 전진해야됨.
			// [0] 에서 시작 길이 2  [0][1] -> 0에서   [0]을 뺀.. 2-1만큼 더간 index..
			//
			if (direction == 1) {
				for (int i = x - 1; i < (x - 1) + length; i++) {
					try {
						arr[i][y - 1] = 1;
					} catch (IndexOutOfBoundsException e) {
						System.out.println(e);
						// throw new ArrayIndexOutOfBoundsException("격자를 넘어간 막대는 무시됩니다.");
					}
				}
			}
		}

		for (int[] row : arr) {
			for (int col : row) {
				System.out.print(col + " ");
			}
			System.out.println();
		}
	}
}
