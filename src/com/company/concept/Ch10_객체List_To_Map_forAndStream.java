package com.company.concept;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

// https://codechacha.com/ko/java-convert-negative-to-positive/
public class Ch10_객체List_To_Map_forAndStream {
	public static void main(String[] args) {
		//0. 자료준비
		List<Item> list = new ArrayList<>();
		list.add(new Item(1, "first"));
		list.add(new Item(2, "second"));
		list.add(new Item(3, "third"));
		list.add(new Item(1, "four"));
		// HashMap<Integer, String> map = new HashMap<>();

		// //1. for문을이용해서 객체list -> 요소1key 요소2value만들기
		// for (Item item : list) {
		// 	map.put(item.getId(), item.getValue());
		// }

		//2. 객체list -> stream으로 맵 만들기
		Map<Integer, String> map = list.stream()
			// .sorted(Comparator.comparingInt(Item::getId).reversed())
			.collect(Collectors.toMap(
				Item::getId,
				Item::getValue,
				(OldId, newId) -> OldId,
				// (OldId, newId) -> newId,
				LinkedHashMap::new
			));
		System.out.println(map);
	}
}

class Item {
	private Integer id;
	private String value;

	public Item(int id, String value) {
		this.id = id;
		this.value = value;
	}

	public int getId() {
		return id;
	}

	public String getValue() {
		return value;
	}
}

