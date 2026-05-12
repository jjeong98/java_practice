package oop.collection.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ArrayListExample {
	public static void main(String[] args) {
	
	
//		String[] arr = new String[50];
		
		//<> 제네릭 - (타입의 형식을 지정하여 타입 안정성 확보를 위한 문법)
		List<String> nick = new ArrayList<>();
		
		//add(객체): 리스트에 객체를 추가하느 메서드
		nick.add("dog");
		String str = "cat";
		nick.add(str);
		nick.add(new String("flog"));
		nick.add("bird");
		nick.add("cat");
		System.out.println("nick = " + nick);
		
		//add(index, object): 원하는 워치에 객체 삽입
		nick.add(3,"tiger");
		System.out.println("nick = " + nick);
		
		//get(index): 리시트 내부의 객체를 참조
		String name = nick.get(3);
		System.out.println("name = " + name);
		System.out.println("nick = " + nick.size());
		
		//set(index, re-write): 리스트 내부의 객체를 수정
		nick.set(2, "bear");
		System.out.println("nick = " + nick);
		
		// 리스트 반복문 처리
		for (int i = 0; i < nick.size(); i++) {
			System.out.println(nick.get(i));
		}
		
		System.out.println("======================");
		
		for (String string : nick) {
			System.out.println(string);
		}
		
		// contains(객체): 리스트 내의 객체의 존재 유무를 파악
		System.out.println(nick.contains("water"));
		
		// indexOf(객체): 특정 객체의 인덱스 탐색, 없다면 -1
		int idx = nick.indexOf("water");
		System.out.println("idx = " + idx);
		
		//remove(객체 | 인덱스): 리스트 내부 객체 삭제
		nick.remove("tiger");
		nick.remove(0);
		System.out.println("nick = " + nick);
		
		//clear(): 리스트 내부 요소 전체삭제
		nick.clear();
		System.out.println("nick = " + nick);
		
		// isEmpty(): 리스트가 비어있는지 확인 여부
		System.out.println(nick.isEmpty());
		
		System.out.println("======================");
		
		/*
		# 컬렉션 객체들은 Collections의 기능을 사용 할 수 있다.
		Collections는 컬렉션 객체들의 부가 기능들을 제공한다.
		 */
		
		// 컬렉션은 객체들의 모음형식이고, 제네릭도 객체 타입만 지정 가능함
		// 기본 데이터 타입은 그냥 못 쓰고, 기본 데이터 타입의 객체 타입을 명시 해 줘야 함.
		List<Integer> score = new ArrayList<>();
		
		/*
        Collections.addAll: 이미 만들어진 컬렉션에 여러 요소를 추가하는 메서드

        Arrays.asList(): add, remove 불가. set()으로 요소 변경은 가능. null 요소 허용
        List.of(): add, remove, set 불가. null 요소 불허. (java 9버전)
         */
		List<Integer> integers = List.of(123, 12, 3, 12, 31, 2, 4, 24, 235);
		List<Integer> integerList = Arrays.asList(1, 23, 4, 24, 2, 35, 2, 5, 2, 35, 2);
		Collections.addAll(score, 1,2,3,4,5,6,7,8);
		System.out.println("score = " + score);
		
		
		
		
		
		// 정렬 (오름차)
		Collections.sort(integerList);
		System.out.println("integerList = " + integerList);
		// 정렬 (내림차)
		Collections.sort(integerList, Collections.reverseOrder());
		System.out.println("integerList = " + integerList);
		
		// 두 요소의 위치를 교체. swap(list, i, j)
		Collections.swap(integerList,0,7);
		System.out.println("integerList = " + integerList);
		
		// 리스트 내의 요소를 무작위로 섞기
		Collections.shuffle(integerList);
		
		// 원하는 객체로 컬렉션을 전부 초기화
		Collections.fill(integerList,1);
		System.out.println("integerList = " + integerList);
		
		
		
	}
}
