package com.company.concept;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

// https://codechacha.com/ko/java-validate-phone-number/
// .:1문자,  .*:문자 0개이상 , .+:1개이상,  .? on/off(없거나 1개있거나)
//Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(string);
public class Ch2_regex_전화번호 {
	public static void main(String[] args) {
		String number1 = "010-1234-5678";
		String number2 = "010-123-45678";
		String number3 = "0101-234-5678";

		validPhoneNumber(number1);
		validPhoneNumber(number2);
		validPhoneNumber(number3);

	}

	private static boolean validPhoneNumber(String number) {
		// python \d 대신 \\d를 쓰는구나.
		Pattern pattern = Pattern.compile("\\d{3}-\\d{4}-\\d{4}");
		Matcher matcher = pattern.matcher(number);
		// System.out.println(matcher); //java.util.regex.Matcher[pattern=\d{3}-\d{4}-\d{4} region=0,13 lastmatch=]
		// System.out.println(matcher.matches()); //matches: true/false반환
		// group():매취된 값을 뽑아냄 -> 매취되는게 없으면 : IllegalStateException
		// 매치되는게 잇을 때 true반환해서,, 원하는 포맷
		// System.out.println(matcher.group()); //010-1234-5678 매취된 값.
		// System.out.println(matcher.find());
		// System.out.println(matcher.matches());
		if (matcher.matches()) {
			return true;
		}
		return false;
	}
}
