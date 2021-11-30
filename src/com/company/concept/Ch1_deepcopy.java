package com.company.concept;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

// 디버깅용 Arrays.toString()은 배열을 찍을수 있다!!
public class Ch1_deepcopy {
	public static void main(String[] args) {
		Integer[] arr = {1, 2, 3, 4, 5};
		Integer[] copy = arr;
		Integer[] copy2 = arr.clone();
		arr[2] = 10;

		ArrayList<Integer> integers = new ArrayList<>();
		integers.add(1);
		integers.add(2);
		integers.add(3);

		System.out.println(Arrays.toString(arr));
		System.out.println(Arrays.toString(copy));
		System.out.println(Arrays.toString(copy2));
		System.out.println(integers);

	}
}
