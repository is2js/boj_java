package com.company.boj;

import java.io.FileInputStream;
import java.util.Scanner;

class Solution {
    public static void main(String args[]) throws Exception {
        System.setIn(new FileInputStream("src/com/company/boj/input.txt"));
        Scanner sc = new Scanner(System.in);

        int T = Integer.parseInt(sc.nextLine());

        //

        for (int test_case = 1; test_case <= T; test_case++) {
            System.out.println("test");
        }
    }
}