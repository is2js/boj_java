package com.company.concept;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

// https://codechacha.com/ko/java-convert-arraylist-to-array/
public class Ch3_List_Or_Stream_To_Array {
	public static void main(String[] args) {
		List<String> list = Arrays.asList("a", "b", "c");
		list.stream().toArray(String[]::new);
		// for (String s : list.stream().toArray(String[]::new)) {
		// 	System.out.println(s);
		// }

		List<Integer> intList = Arrays.asList(1, 2, 3);
		Integer[] integers = intList.stream().toArray(Integer[]::new);
		// for (Integer integer : integers) {
		// 	System.out.println(integer);
		// }

		String[] strings = list.toArray(list.toArray(new String[0]));
		// for (String string : strings) {
		// 	System.out.println(string);
		// }

		String[] strings1 = list.stream().toArray(String[]::new);
		// for (String s : strings1) {
		// 	System.out.println(s);
		// }

		// ex1 > list<String> -> stream + map -> array
		ArrayList<String> li1 = new ArrayList<>();
		li1.add("a");
		li1.add("b");
		li1.add("c");

		String[] li1Array = li1.stream()
			.map(String::toUpperCase)
			.toArray(String[]::new);

		// for (String s : li1Array) {
		// 	System.out.print(s + " ");
		// }

		//ex2> list<Integer> -> stream + map  -> array
		ArrayList<Integer> li2 = new ArrayList<>();
		li2.add(1);
		li2.add(2);
		li2.add(3);
		Integer[] li2Array = li2.stream().map(x -> x * x).toArray(Integer[]::new);
		// for (Integer integer : li2Array) {
		// 	System.out.println(integer);
		// }

		//ex3> int arr -> Intstream -> Integer arr
		// -> int배열을  stream화 하면 ,, stream이 아니라 IntSream이구나..
		// -> Map으로 변형다하고 나서 데이터변형직전에 .boxed()
		int[] num = {1, 2, 3};
		IntStream stream = Arrays.stream(num);
		Integer[] integers1 = stream.map(x -> x * x)
			.boxed()
			.toArray(Integer[]::new);
		// for (Integer integer : integers1) {
		// 	System.out.println(integer);
		// }

		//ex4> int arr -> Intstream -> Integer가 아닌 Int arr
		// -> boxed필요없음 + 생성자 필요없음
		int[] num2 = {1, 2, 3};
		int[] ints = Arrays.stream(num2).map(x -> x * x).toArray();
		for (int i : ints) {
			System.out.println(i);
		}

	}
}

