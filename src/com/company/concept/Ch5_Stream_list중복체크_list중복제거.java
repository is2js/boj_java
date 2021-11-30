package com.company.concept;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;

// https://codechacha.com/ko/java8-convert-stream-to-list/
public class Ch5_Stream_list중복체크_list중복제거 {
	public static void main(String[] args) {

		String[] arr = {"a", "b", "c", "d", "a", "e"};
		List<String> list = Arrays.asList(arr);

		// if (list.size() == list.stream().distinct().count()) {
		// 	System.out.println("List contains duplicates");
		// }

		// System.out.println((list.stream().distinct().collect(Collectors.toList())));

		// Set이용해보기
		HashSet<String> set = new HashSet<>(list);
		LinkedHashSet<String> set2 = new LinkedHashSet<>(list);

		set.add("h");
		set.add("k");
		set2.add("h");
		set2.add("k");
		System.out.println(set);
		System.out.println(set2);

	}
}

