package com.company.codeup;

import java.io.FileInputStream;
import java.util.Scanner;

class Solution4_6095_1096 {
  public static void main(String args[]) throws Exception {
    System.setIn(new FileInputStream("src/com/company/codeup/input.txt"));
    Scanner sc = new Scanner(System.in);

    int T = Integer.parseInt(sc.nextLine());
    // 1. split " " -> string[] 배열
    //        String[] splitedArr = sc.nextLine().split(" ");
    // 2. string[]배열 -> parseInt -> arrayList
    //         ArrayList<Integer> arr = (ArrayList<Integer>) =
    // Arrays.stream(splitedArr).map(Integer::parseInt).collect(Collectors.toList());
    int[][] arr = new int[20][20];

    for (int test_case = 1; test_case <= T; test_case++) {
        String[] splitedArr = sc.nextLine().split(" ");
        int x = Integer.parseInt(splitedArr[0]);
        int y = Integer.parseInt(splitedArr[1]);

        arr[x-1][y-1] = 1;
    }

    for(int i = 0 ; i < arr.length-1; i++ ) {
        for (int j = 0; j < arr[0].length -1; j++) {
            System.out.print(arr[i][j] + " ");
        }
        System.out.println();
      }

  }
}
