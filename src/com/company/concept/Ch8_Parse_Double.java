package com.company.concept;

// https://codechacha.com/ko/java-convert-negative-to-positive/
public class Ch8_Parse_Double {
	public static void main(String[] args) {

		String str = "123.456";
		double v1 = Double.parseDouble(str);
		double v2 = Double.valueOf(str);

		System.out.println(v1);
		System.out.println(v2);

	}
}

