package com.company.concept;

import java.util.Arrays;
import java.util.List;

public class Ch13_익명클래스_인터페이스참조변수자리_To_람다 {
	public static void main(String[] args) {
		List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5, 6);

		System.out.println(sumAllEven(integers));
		System.out.println(sumAllOverThree(integers));

		//5. 구현체Class를 생성 -> 객체생성 -> new 객체를 넣어줘도 되지만,
		// -> 인페 참조변수 자리에 -> 강통메서드를 자동오버라이딩하는, 람다식을 넣어줘도된다.
		System.out.println((sumAll(integers, x -> x > 3)));
		//6. 테스트용으로 강통메서드의 return결과인 boolean식을  람다 -> 결과를 무조건 true로
		System.out.println((sumAll(integers, x -> true )));
		System.out.println((sumAll(integers, x -> x%2==0 )));

	}

	// 1. 0포함 짝수만 더하는 메서드
	private static int sumAllEven(List<Integer> integers) {
		int total = 0;
		for (Integer integer : integers) {
			if (integer % 2 == 0) {
				total += integer;
			}
		}
		return total;
	}

	//2. 다 똑같은데 짝수 대신 3보다 큰수만 더하는 조건으로 코드가 바꿈
	private static int sumAllOverThree(List<Integer> integers) {
		int total = 0;
		for (Integer integer : integers) {
			if (integer > 3) {
				total += integer;
			}
		}
		return total;
	}

	//4. 바뀌는 코드부분을
	// 1) 인터페이스참조변수.강통메서드()호출로 채울 수 있게 함.
	// 2) 그러려면 (인터페이스 참조변수)를 객체-생성자, 메서드-파라미터 에서 받아준다.
	// int sumAll(List<Integer> integers) {
	static int sumAll(List<Integer> integers, Conditional conditional) {
		int total = 0;
		for (Integer integer : integers) {
			if (conditional.apply(integer)) {
				total += integer;
			}
		}
		return total;
	}

}

//3.  바뀌는 코드부분을  조합용구현체 객체.강통메서드()로 채울 interface 생성
// - 바뀌는 코드 -> 외부 구현체class가 코드를 결정 && 랜덤부분을 강통메서드()호출로 사용하여 매번 새롭게 랜덤 &&
// -> 특정 변수를 사용하면 변수로 받도록 메서드를 작성.
interface Conditional {
	boolean apply(int number);
}


