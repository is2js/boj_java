package com.company.boj;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

class Solution5_1316 {

	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("src/com/company/boj/input.txt"));
		Scanner sc = new Scanner(System.in);

		int T = Integer.parseInt(sc.nextLine());

		// 알파벳 갯수만큼, 재등장을 체크할 수 있는 배열 생성
		boolean[] check = new boolean[26];

		int groupWordCount = T;
		for (int test_case = 1; test_case <= T; test_case++) {
			Arrays.fill(check, false);
			// 아스키코드써야해서 char로 변환
			char[] chars = sc.nextLine().toCharArray();
			// i+1때문에 직접 배열로 만들고, 고전for문 접근함.
			for (int i = 0; i < chars.length; i++) {
				// char - int는 int가 되나보다. a를 0기준으로 보려면,  어떤 char든 -97때리면 된다.
				// 나타나는 순간 true를 주고, 흐름이 끊긴뒤 또 나타나면.. 그룹단어 파기다.
				if (!(check[chars[i] - 97]) && (i != chars.length-1 && chars[i] != chars[i + 1])) {
					check[chars[i] - 97] = true;
					continue;
				}
				if (check[chars[i] - 97]) {
					groupWordCount--;
					break;
				}
			}

		}
		System.out.println(groupWordCount);

	}
}
