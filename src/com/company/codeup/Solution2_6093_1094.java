// package com.company.codeup;
//
// import java.io.FileInputStream;
// import java.util.ArrayList;
// import java.util.List;
// import java.util.Scanner;
//
// class Solution2_6093_1094 {
//     public static void main(String args[]) throws Exception {
//         System.setIn(new FileInputStream("src/com/company/codeup/input.txt"));
//         Scanner sc = new Scanner(System.in);
//
//         int T = Integer.parseInt(sc.nextLine());
//
//         //https://codeup.kr/problem.php?id=6093
//         //선생님 부른것 거꾸로 출력해보기
//         String s = sc.nextLine();
// //        ArrayList<String> arr = s.split(" ");
// //        오옷.. split()한 것은 java.lang.String[] 배열이라서... 바로arraylist에 못담는다!!
// //        String[] arr = s.split(" ");
//         ArrayList<String> arr = new ArrayList<>(List.of(s.split(" ")));
//
// //        for(int i = arr.length-1; i>=0; i--) {
//         for(int i = arr.size()-1; i>=0; i--) {
// //          System.out.print(arr[i] + " ");
//           System.out.print(arr.get(i) + " ");
//         }
//
//
//
// //       for (int test_case = 1; test_case <= T; test_case++) {
// //            System.out.println("test");
// //        }
//     }
// }
