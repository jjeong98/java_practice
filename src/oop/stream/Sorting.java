package oop.stream;

import java.util.Comparator;
import java.util.List;

import static java.util.Comparator.comparing;
import static java.util.Comparator.reverseOrder;
import static oop.stream.Menu.MENU_LIST;

public class Sorting {
	public static void main(String[] args) {
		
		List<Dish> meatAsc = MENU_LIST.stream()
				.filter(dish -> dish.getType() == Dish.Type.MEAT)
				.sorted(comparing(dish -> dish.getCalories()))
				.toList();
				
		meatAsc.forEach(System.out::println);
		
		System.out.println("------------------");
		
		MENU_LIST.stream()
				.filter(dish -> dish.getCalories() >= 300)
				// 칼로리 오름차순으로 진행하되, 칼로리가 같다면 이름 내림차순
				.sorted(comparing(Dish::getCalories).thenComparing(Dish::getName, reverseOrder()))
				.limit(3)
				.forEach(System.out::println);
		
		
		
	}
}
