package com.company.concept;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ch12_Stream_minmax_All {
	public static void main(String[] args) {
		//1. Intlist -> stream  + mapToInt ->  IntStream -> max()
		List<Integer> list = Arrays.asList(2, 3, 6, 4, 10, 23);
		int max = list.stream()
			// .max() // IntegerList는 바로 max()를 못먹인다... 왜냐면 IntStream이 아니라..
			// IntStream만 .max()가 적용된다.
			// -> 객체stream이라면, max(Car::compareTo) 로서, 단일객체Class내부에 compareTo -> return Int로 매핑하는 메서드가 max()의 인자로 들어가야한다.
			.mapToInt(x -> x) // 그냥 IntegerList라도, mapToInt(x->x)해야 IntStream이 된다.
			.max()
			.orElseThrow(NoSuchElementException::new);
		// System.out.println(max);

		//2. IntList -> stream -> max( Comparator.comparing( x -> x 여기서 int로 형변환하는 듯) )
		// cf) 객체 -> getter로 기준 주기 .sorted(Comparator.comparingInt(Item::getId).reversed())
		// List<Integer> list = Arrays.asList(2, 3, 6, 4, 10, 23);
		Integer max2 = list.stream()
			.max(Comparator.comparing(x -> x))
			// .max(Comparator.comparingInt(x->x.getter())) // getter 등 객체에서 mapping해서 기준을 잡을 때
			.orElseThrow(NoSuchElementException::new);

		// IntStream() -> max()의 결과는 int
		// stream() -> max( Comparator ) 의 결과는 Integer
		// System.out.println(max2);

		//3 int[] Array  -> 바로 IntStream 됨..  -> 그냥 max() 바로됨.  -> int로 반환
		int[] intArray = {3, 2, 6, 10, 234};
		int max3 = Arrays.stream(intArray)
			.max()
			// .getAsInt(); // max()로 나오는 Optional을 에러감안하고 int로 받는다는것.
			.orElseThrow(NoSuchElementException::new);
		// System.out.println(max3);

		//4. 객체list -> 특정필드 max가진 객체 찾기 ex> 나이가 제일 많은 객체 찾기

		//1) 객체list 만드려면,
		// (1) 객체들을 생성할 [외부재료list ]-> stream -> .map( v -> 객체생성(v) ) or
		// 없다면 IntStream.range(0,size)으로 그 갯수만큼 객체생성 + index로 활용 할 [size]  -> .mapToObj( i -> 객체생성(i)
		int size = 5;
		List<Student> studentsList = IntStream.range(0, size)
			.mapToObj(i -> new Student("name" + i, i + 10))
			.peek(System.out::println) // 중간처리 메소드, forEach 최종처리 메서드랑 똑같이 일시키는데, 뒤에 메서드가 더잇어야함. 로그찍기용
			.collect((Collectors.toList()));

		//2) 객체list -> intStream은 될 수 없으니, max()인자에 기준을 넣어주는식으로 해야한다.
		// -> max의 기준에는
		// (1) IntStream(int[] arrays도 변환시 intstream)은 아니지만, int인 경우 ex> intList
		// -> Comparator.comparing( x->x)
		// (2) 전혀 Int가 아닌 stream이 오는 경우
		// -> Comparator.comparingInt( 해당StreamClass:: getter메서드 )
		// 를 max기준으로 넣어주면 된다.
		Student student = studentsList.stream()
			.max(Comparator.comparingInt(Student::getAge))
			.orElseThrow(NoSuchElementException::new);
		// System.out.println(student.getAge());

		//5. String[] arr or String list ( int[] arr -> 바로 IntStream가 아닌 모든 것)

		// -> ***list, 문자열 배열 등 int배열, intStream이 아닌 모든 것에
		// -> 기준없는 max()를 매길려면 -> mapToInt()가 들어가야한다.***

		// -> 길이는 mapToInt( String::length) 가 있다. 각 단일stream의 메서드참조를 생각하자.

		//***
		// 최대값만 구한다 -> mapToInt() -> max()
		// 최대값에 해당하는 객체 등 원본을 구한다 -> max( Comparator.comparingInt( Class::Getter))
		//***
		String[] lines = {"Hello", "My", "World"};
		int max4 = Arrays.stream(lines)
			.mapToInt(String::length)
			.max()
			.orElseThrow(NoSuchElementException::new);
		System.out.println(max4);

	}
}

class Student {
	private String name;
	private int age;

	public Student(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}
}
