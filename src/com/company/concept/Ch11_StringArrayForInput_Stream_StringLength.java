package com.company.concept;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Ch11_StringArrayForInput_Stream_StringLength {
	public static void main(String[] args) {

		//1. input을 split한 상황이라 치고 String[]을 만든다.
		String[] strings = {"", "Kiwi", "Cherry", "Peach", ""};

		//2. 문자열 길이확인을 굳이 map으로 변환해서 누락안되어도.. filter or Match에서 변형해서 확인하면 된다.
		boolean b = Arrays.stream(strings)
			.anyMatch(s -> s.length() < 1);

		System.out.println(b);

		//3. 나는 mapToInt로 실제 길이로 변환하다가 빈문자열이 누락되어버렸다.
		// -> 여기선또.. 잘 나오는 듯..?
		List<Integer> collect = Arrays.stream(strings)
			.mapToInt(s -> s.length())
			// .anyMatch(length -> length < 1);
			.boxed()
			.collect(Collectors.toList());
		System.out.println(collect);

	}
}
