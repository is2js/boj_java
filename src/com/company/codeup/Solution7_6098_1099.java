package com.company.codeup;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

// 느낀점
// 1. 2차원배열은 각 row마다 밀어넣는데, 붙어있는 문자열이라면, split(" ")말고 toCharArray ''를 쓴다.
// 2. DFS, 재귀없는 좌표탐색시, 방향벡터를 돌 때, 모든 방향 다 돌고 나오는게 아니라
// -> **다음좌표찾았으면 break로 자식방향루프 빠져나와서 -> 검사 -> 처음방향부터 순회되도록해야한다.**
// --> 계속해서 그거 돌고 있게 두면 안됨. ex> 동서남북 중 동에서 좌표발견? 좌표업데이트이후 break -> 다시 동부터  ( ->서->남->북 으로 이어지도록 X)

class Solution7_6098_1099 {

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
		// 2차원 배열 받기
		final int N = 10;
		final int M = 10;
		String[][] arr = new String[N][M];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextLine().split(" ");
		}

		// 참고) 스페이스가 아니라 0101010붙어있는 2차원 배열
		// 1. arr 배열을 char형으로 선언해야한다. ex>arr = new char[N + 1][M + 1];
		// 2. split()대신 toCharArray() eX> arr[i] = sc.readLine().toCharArray();
		// 2. char형으로 저장되므로 숫자와 비교시 작은 따옴표를 붙혀야함. ex>System.out.println(arr[0][7] == '1');
		// 3. arr 배열의 값을 변경할때 주의한다. ex>arr[0][7] = '9';

		// 미리 이동 방향벡터 리스트를..
		List<Integer> dx = Arrays.asList(0, 1);
		List<Integer> dy = Arrays.asList(1, 0);

		int x = 1;
		int y = 1;
		arr[x][y] = "9";

		int count = 10;
		int j = 0;
		while (j < count) {
			j++;
			System.out.println("x,y = " + x + ", " + y);
			if (arr[x][y].equals("2")) {
				System.out.println("찾았다.");
				break;
			}
			for (int i = 0; i < dx.size(); i++) {
				int xx = x + dx.get(i);
				int yy = y + dy.get(i);
				// System.out.println("xx,yy = " + xx + ", " + yy);

				if (!(1 <= xx && xx < 10 && 1 <= yy && yy < 10)) {
					continue;
				}
				if (arr[xx][yy].equals("1")) {
					continue;
				}
				if (arr[xx][yy].equals("2")) {
					x = xx;
					y = yy;
					System.out.println("다음께 2래요.. 종료할게요..->" + x + ", " + y);
					break;
				}
				x = xx;
				y = yy;
				if (arr[x][y].equals("0")) {
					System.out.println("업데이트되었습니다.");
					arr[x][y] = "9";
					// 업데이트마다, 다시 루프를 돌아서 오른쪽-> 아래쪽, 순으로 돌아야한다.
					// 만약 오른쪽 업데이트되더라도 오른쪽 ->아래쪽순으로 아래쪽을 업데이트 하면 안된다.
					// 오른쪽이든, 아래쪽이든, 한번 걸렸으면, 검사를 시작으로 하고, 오른쪽부터 탐색하도록 다시 루프를 돌아야한다.
					break;
				}
			}
		}

	}
}
