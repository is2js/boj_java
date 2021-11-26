package com.company.codeup;

import java.io.FileInputStream;
import java.util.*;
import java.util.stream.Collectors;

class Solution3_6094_1095 {
  public static void main(String args[]) throws Exception {
    System.setIn(new FileInputStream("src/com/company/codeup/input.txt"));
    Scanner sc = new Scanner(System.in);

    int T = Integer.parseInt(sc.nextLine());

    // 1. split " " -> string[] 배열
    String[] splitedArr = sc.nextLine().split(" ");
    // for문 돌면 형변환 parseInt -> arr(ayList)에 담기
    //        ArrayList<Integer> arr = new ArrayList<>();
    //        for(String e : splitedArr) {
    //            arr.add(Integer.parseInt(e));
    //        }
    // 2. stream으로 arr에 -> map 메서드참조 parseInt해서 -> arraylist에 담기
    ArrayList<Integer> arr =
        (ArrayList<Integer>)
            Arrays.stream(splitedArr).map(Integer::parseInt).collect(Collectors.toList());
    // 2-2. 원래는 arr ---Arrays.asList()--> list --new ArrayList( list )--> arraylist가 정석
//    ArrayList<String> arr = new ArrayList<>(Arrays.asList(splitedArr));
    // 2-3. arr + 빈 ArrayList -> Collections.addAll( 빈arraylist, arr)
//            ArrayList<String> list = new ArrayList<>();
//            Collections.addAll( list ,  splitedArr );
    //        System.out.println(list.get(0));

    // 3. 최소값을 update하면서 찾기
    int minimum = arr.get(0);
    for (int i = 0; i < arr.size(); i++) {
      if (arr.get(i) < minimum) {
        minimum = arr.get(i);
      }
    }
    System.out.println(minimum);
  }
}
