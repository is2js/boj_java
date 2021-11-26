package com.company.boj;

import java.io.FileInputStream;
import java.util.Scanner;

class Solution {
    public static void main(String args[]) throws Exception {
        System.setIn(new FileInputStream("src/com/company/boj/input.txt"));
        Scanner sc = new Scanner(System.in);

        int T = Integer.parseInt(sc.nextLine());
        // 1. split " " -> string[] 배열
        //String[] splitedArr = sc.nextLine().split(" ");
        // 2. string[]배열 -> parseInt -> arrayList
        //ArrayList<Integer> arr = (ArrayList<Integer>) = Arrays.stream(splitedArr).map(Integer::parseInt).collect(Collectors.toList());


        for (int test_case = 1; test_case <= T; test_case++) {
            System.out.println("test");
        }
    }
}