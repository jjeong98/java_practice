package oop.stream;

import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import static oop.stream.Menu.*;

public class Grouping {
	public static void main(String[] args) {
	
		//채식요리와 아닌 요리로 메뉴를 나눠보자.
		// 두 분류로 나누어 줌. (분류 기준은 논리값으로 전달해 주어야 함)
		Map<Boolean, List<Dish>> veggieMenu = MENU_LIST.stream()
				.collect(Collectors.partitioningBy(Dish::isVegetarian));
		
		System.out.println("---채식---");
		veggieMenu.get(true).forEach(System.out::println);
		
		System.out.println("---일반---");
		veggieMenu.get(false).forEach(System.out::println);
		
		System.out.println("------------------");
		
		//요리를 종류(타입별)로 그룹화
		Map<Dish.Type, List<Dish>> menuByType = MENU_LIST.stream()
				.collect(Collectors.groupingBy(Dish::getType));
		
		System.out.println("---육류---");
		menuByType.get(Dish.Type.MEAT).forEach(System.out::println);
		
		System.out.println("------------------");
		
		// 종류별로 나눈 메뉴를 칼로리 기준
		Map<Dish.Type, Map<String, List<Dish>>> detailedMenu =
				MENU_LIST.stream()
				.collect(Collectors.groupingBy(Dish::getType, //1차 분류
						Collectors.groupingBy(dish -> {
							if (dish.getCalories() > 500) return "고칼로리";
							else return "저칼로리";
						}) //2차 분류
				
				));
		detailedMenu.get(Dish.Type.OTHER).get("저칼로리").forEach(System.out::println);
		
		System.out.println("------------------");
		
		//종류별 요리 개수
		Map<Dish.Type, Long> dishCount = MENU_LIST.stream()
				.collect(Collectors.groupingBy(Dish::getType, Collectors.counting()));
		
		System.out.println("dishCount = " + dishCount);
		
		// 종류별 총 칼로리
		Map<Dish.Type, Integer> totalCalBytType = MENU_LIST.stream()
				.collect(Collectors.groupingBy(Dish::getType, Collectors.summingInt(Dish::getCalories)));
		
		System.out.println("totalCalBytType = " + totalCalBytType);
		
		 System.out.println("------------------");
		
		Map<Dish.Type, IntSummaryStatistics> calSummary = MENU_LIST.stream()
				.collect(Collectors.groupingBy(Dish::getType,
						Collectors.summarizingInt(Dish::getCalories)));
		
		// 요리 종류별로 그룹화 후 칼로리에 대한 통계 꾸러미가 리턴. (개수 평균, 합계, 최대/최소)
		System.out.println("calSummary = " + calSummary);
	}
}
