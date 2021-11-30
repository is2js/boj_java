package com.company.concept;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

// https://codechacha.com/ko/java8-convert-stream-to-list/
public class Ch4_Stream_To_List {
	public static void main(String[] args) {

		//1. 스트림생성은 .of static메소드다
		Stream<String> stream = Stream.of("Java8", "and", "Stream", "examples");
		// String[] array = stream.toArray(String[]::new);
		// List<String> list = Arrays.asList(array);

		//2. Stream<String> -> list : collect(Collectors.toList())
		// List<String> list1 = stream.collect(Collectors.toList());
		// System.out.println(list1);

		//3. IntStream -> Stream<Integer> -> Integer[] array -> list<Integer>
		// IntStream intStream = IntStream.range(1, 5);
		// Stream<Integer> integerStream = intStream.boxed();
		// Integer[] integers = integerStream.toArray(Integer[]::new);
		// List<Integer> integers1 = Arrays.asList(integers);
		// System.out.println(integers1);

		//4.IntStream -> Stream<Integer> -> List<Integer>
		List<Integer> collect = IntStream.range(1, 5)
			.boxed()
			.collect(Collectors.toList());

	}
}

