package com.company.boj;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Scanner;

class Solution2_7568 {

	public static final int N = 5;

	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("src/com/company/boj/input.txt"));
		Scanner sc = new Scanner(System.in);

		int T = Integer.parseInt(sc.nextLine());
		ArrayList<int[]> list = new ArrayList<>();
		for (int test_case = 1; test_case <= T; test_case++) {
			String[] splitedValues = sc.nextLine().split(" ");
			int first = Integer.parseInt(splitedValues[0]);
			int second = Integer.parseInt(splitedValues[1]);
			list.add(new int[] {first, second});
		}
		for (int[] ints : list) {
			for (int anInt : ints) {
				System.out.print(anInt + " ");
			}
			System.out.println();
		}

		//각 item마다 index에 나보다 랭킹높은 놈의 정보를 저장하는 배열 생성
		int[] ranks = new int[list.size()];
		//
		for (int i = 0; i < list.size(); i++) {
			int higherThanMe = 0;
			int[] item = list.get(i);
			for (int j = 0; j < list.size(); j++) {
				if (i == j) {
					continue;
				}
				int[] item2 = list.get(j);
				if (item[0] < item2[0] && item[1] < item2[1]) {
					// System.out.print("나 >> " + item[0] + ", " + item[1]);
					// System.out.println("보다 큰놈 찾음 " + item2[0] + ", " + item2[1]);
					higherThanMe++;
				}
			}
			ranks[i] = higherThanMe + 1; // 나보다 큰놈 0 -> 랭킹1등.
		}

		for (int rank : ranks) {
			System.out.print(rank + " ");
		}
	}
}
