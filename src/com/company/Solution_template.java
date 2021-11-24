package com.company;

import java.io.FileInputStream;
import java.util.Scanner;

class Solution_template {
    public static void main(String args[]) throws Exception {
        System.setIn(new FileInputStream("src/com/company/input.txt"));
        Scanner sc = new Scanner(System.in);

        int T = Integer.parseInt(sc.nextLine());

        sc.nextLine().split(" ");
        for (int test_case = 1; test_case <= T; test_case++) {
            System.out.println("test");
        }
    }
}