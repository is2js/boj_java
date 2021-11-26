package com.company.codeup;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Scanner;

class Solution5_6096_1097 {
	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("src/com/company/codeup/input.txt"));
		Scanner sc = new Scanner(System.in);

		// 1. split " " -> string[] 배열
		//        String[] splitedArr = sc.nextLine().split(" ");
		// 2. stream으로 arr에 -> map 메서드참조 parseInt해서 -> arraylist에 담기
		//         ArrayList<Integer> arr = (ArrayList<Integer>) =
		// Arrays.stream(splitedArr).map(Integer::parseInt).collect(Collectors.toList());

		// 1) 일단 문자열 행들을 <문자열 2차원 배열>에 일단 집어넣는다.
		String[][] arr = new String[19][19];

		for (int i = 0; i < arr.length; i++) {
			// 행별로, 그냥 split해서 밀어넣어버린다. split의 결과가 문자열 배열이므로
			arr[i] = sc.nextLine().split(" ");
			//            System.out.println(arr[i]);
			//            for(String col: arr[i]) {
			//                System.out.print(col + " ");
			//            }
			//            System.out.println();
		}

		// 2) 데이터저장은 아무래도, arraylist에 add로 한다.
		// -> "x y" 좌표는 split없이..문자열로 그냥 list에 저장해두자.
		ArrayList<String> list = new ArrayList<>();
		int T = Integer.parseInt(sc.nextLine());
		for (int i = 1; i <= T; i++) {
			list.add(sc.nextLine());
		}
		//        System.out.println(list); // [10 10, 12 12]

		// 3) 좌표들을 돌면서, 행 고정 -> for열 로 행처리
		//   열고정 -> for 행으로 열 처리
		// 문자열을 swiching해준다. python의 경우, bool() -> int()로 편하게.. 스위칭된다.
		for (String s : list) {
			String[] point = s.split(" ");
			int x = Integer.parseInt(point[0]);
			int y = Integer.parseInt(point[1]);

			for (int i = 0; i < arr.length; i++) {
				String k = arr[i][y - 1];
				if (k.equals("0")) {
					arr[i][y - 1] = "1";
				} else {
					arr[i][y - 1] = "0";
				}
			}
			for (int j = 0; j < arr.length; j++) {
				String k = arr[x - 1][j];
				if (k.equals("0")) {
					arr[x - 1][j] = "1";
				} else {
					arr[x - 1][j] = "0";
				}
			}
		}

		for (String[] row : arr) {
			for (String col : row) {
				System.out.print(col + " ");
			}
			System.out.println();
		}
	}
} 