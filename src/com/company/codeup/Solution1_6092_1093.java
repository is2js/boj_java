package com.company.codeup;

import java.io.FileInputStream;
import java.util.Scanner;

class Solution1_6092_1093 {
    public static void main(String args[]) throws Exception {
        System.setIn(new FileInputStream("src/com/company/codeup/input.txt"));
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        //미리 빈 배열을 만들어놓는다.
        // -> 23번도 쓰기 위해 갯수를 23개로
        // int의 초기화는 int에
        int[] students = new int[24];

        for (int test_case = 1; test_case <= T; test_case++) {
            int number = sc.nextInt();
            students[number] += 1;
        }

        // 23번까지 쓰려고 24개를 선언했다하더라도.. .length는 24다..
        // index는 언제나 length(24)-1 = 23이 마지막
        for(int i = 1; i < students.length; i++) {
            System.out.printf("%d", students[i]);
        }
    }
}