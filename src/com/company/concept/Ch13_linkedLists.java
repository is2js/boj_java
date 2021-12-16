package com.company.concept;

import java.util.ArrayList;
import java.util.LinkedList;

public class Ch13_linkedLists {
	public static void main(String[] args) {
		// 일반적으로 LinkedList의 장점은 데이터를 추가하거나 삭제하는 것이 원활하다는 점입니다.
		//
		// 	어느 위치에서든 추가나 삭제를 할 경우 변경되는 노드만 다시 연결해주면 됩니다.
		//
		// 그래서 주로 ArrayList는 검색이 많은 경우에 사용하고 LinkedList는 잦은 삽입/삭제 시 사용합니다.
		LinkedList<String> linkedList = new LinkedList<>();
		ArrayList<String> arrayList = new ArrayList<>();

		linkedList.add("Black");
		linkedList.add("White");
		linkedList.add("Green");
		linkedList.add("Black");
		linkedList.add("Red");
		linkedList.add("Blue");
		arrayList.add("Black");
		arrayList.add("White");
		arrayList.add("Green");
		arrayList.add("Black");
		arrayList.add("Red");
		arrayList.add("Blue");

		//set 수정
		linkedList.set(0, "FirstColor");
		arrayList.set(0, "FirstColor");

		//insert by add(index, )
		linkedList.add(1, "SecondColor");
		arrayList.add(1, "SecondColor");
		linkedList.add(0, "0");
		arrayList.add(0, "0");

		//remove(index)  or remove(객체)
		linkedList.remove(0);
		arrayList.remove("0");

		//[FirstColor, SecondColor, White, Green, Black, Red, Blue]
		// [FirstColor, SecondColor, White, Green, Black, Red, Blue]

		// if remove -> removeIf(  lambda식 )
		linkedList.removeIf(element -> element.equals("White"));
		arrayList.removeIf(element -> element.equals("Green"));

		//전체삭제 clear
		linkedList.clear();
		arrayList.clear();

		System.out.println(linkedList);
		System.out.println(arrayList);
	}
}
