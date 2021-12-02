package com.company.concept;

// https://codechacha.com/ko/java-check-if-string-empty-or-null/
public class Ch7_isString_null_Or_empty {
	public static void main(String[] args) {

		String s = " ";
		if (s == null || s.trim().isEmpty()) {
			System.out.println("입력을 정확하게 해주세요");
		}

	}
}

