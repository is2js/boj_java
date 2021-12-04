package com.company.concept;

// https://codechacha.com/ko/java-convert-negative-to-positive/
public class Ch9_String_reverse {
	public static void main(String[] args) {
		String str = "Hello, world!";
		StringBuilder stringBuilder = new StringBuilder(str);
		String s = stringBuilder.reverse().toString();
		// System.out.println(s);

		// Arrays.stream(str.split(""))
		// .sorted(Collections.reverseOrder())
		// .sorted(Comparator.reverseOrder())
		// .collect(inReversed())
		// .forEach(System.out::print);

		// stream은 역순이 어렵다 -> 리스트는 쉽다?
		// List<String> stringList = Arrays.asList(str.split(""));
		// Collections.reverse(stringList); // [!, d, l, r, o, w,  , ,, o, l, l, e, H]
		// String s1 = stringList.stream()
		// 	.reduce((a, b) -> (a + b))
		// 	.get();
		// System.out.println(s1);

		for (int i = str.length() - 1; i >= 0; i--) {
			char c = str.charAt(i);
			System.out.print(c);
		}

	}

}
