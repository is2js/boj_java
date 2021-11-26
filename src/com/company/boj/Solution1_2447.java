package com.company.boj;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

class Solution1_2447 {

	private static char[][] arr2d;

	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("src/com/company/boj/input.txt"));
		Scanner sc = new Scanner(System.in);

		// 1. 빈 문자열 배열 만들어놓기
		int N = Integer.parseInt(sc.nextLine());
		arr2d = new char[N][N];
		for (char[] row : arr2d) {
			Arrays.fill(row, ' ');
		}

		// 2. 재귀함수로 처리해보기
		star(N, 0, 0); // arr[][]시작좌표를 왜 0,0으로 주는지는 모르겠음.

		// 6. 재귀(n번째, 시작,좌표)  로 다 칠해졌다면, 출력해보자.
		for (char[] row : arr2d) {
			System.out.println(row);
		}
	}

	private static void star(int n, int a, int b) {
		// 한변이 1인 배열 + 시작좌표0,0이면 그냥 1칸만 채우면 된다.
		if (n == 1) {
			arr2d[a][b] = '*';
			return;
		}

		//3. 일단 27x27을 -> 1/3해서 9x9 짜리 star()를 이용해서 만든다.
		// n -> n-1의 조합이 아니라, n -> n//3과의 조합이다.
		int div = n / 3;

		//4. 아~ 27/3 -> 9로서, 한변의 길이가 9인  9x9 배열이 총 9-1이 된다.
		// -> 각 9-1개의 배열에 칠을 할건데, 9개마다 시작좌표가 다르니 옮겨준다.
		// -> 시작좌표만 달라진체로 star(n/3)으로 정복했다고 가정하고 식을 짠다.
		// my) return star(n/3) 형태 대신, arr를 시작좌표 여러개로 색칠(like 프린터)하는 것으로 대체한다.
		// --> 3개가 그려지도록 2중 반복문을 짠다. -> 총 9번 그린다.
		// --> 시작좌표(0,0)이라 가정하면,
		// row별로 0,0             0+(n/3)*1, 0,     0+(n/3)*2, 0
		// col별로 0,0+(n/3)*1
		// col별로 0,0+(n/3)*2  이렇게 시작되야하며,   (1,1)에서는 반복문을 건너뛰어야한다.(continue)
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				//4-1) row고정이라치고, col부터 처리해보자.
				// -> 일단 0,1,2 중 가운데 면서 , row도 가운데는 시작좌표 색칠안한다.
				if (j == 1 && i == 1) {
					continue;
				}
				//4-2) y좌표 b에서 시작해서, 0,1,2 * (n/3)씨작 시작좌표를 옮겨야한다.
				star(div, a + i * (div), b + j * (div));
			}
		}

	}

}

