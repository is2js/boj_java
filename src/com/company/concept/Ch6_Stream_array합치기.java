package com.company.concept;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// https://codechacha.com/ko/java-join-arrays/
public class Ch6_Stream_array합치기 {
	public static void main(String[] args) {

		String[] arr1 = {"a", "b", "c", "d", "e"};
		String[] arr2 = {"1", "2", "3", "4", "4"};
		// 원래는 각각의 길이 입력 -> 돌면서 다 한곳에 넣기
		// Stream.of()는 콤마로 각 원소들을 받는데,
		// -> 받아서 flatMap( Stream::of)로 각각을 스트림으로 변형해서, 합친다.

		// 1.배열을 콤마로 입력하면, 그냥 원소가 될뿐.
		Stream<String[]> arr11 = Stream.of(arr1, arr2);
		// 2. flatmap(Stream::of) 는 모든 원소를 1차원 stream에 모은다.
		Stream<String> stringStream = arr11.flatMap(Stream::of);
		// 3.
		List<String> collect = stringStream.collect(Collectors.toList());
		System.out.println(collect);

	}
}

