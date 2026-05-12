package oop.lambda;

import java.util.List;
import java.util.logging.Filter;

import static oop.lambda.Color.*;

public class Main {
	public static void main(String[] args) {
		
		// 사과 바구니 생성
		// List.of -> 고정형 리스트 생성 (Arrays.asList와 유사)
		List<Apple> appleBasket = List.of(
				new Apple(80, GREEN)
				, new Apple(155, GREEN)
				, new Apple(120, RED)
				, new Apple(97, RED)
				, new Apple(200, GREEN)
				, new Apple(50, RED)
				, new Apple(85, YELLOW)
				, new Apple(75, YELLOW)
		);
		
		System.out.println("--------녹색 사과 필터-----------");
		
		List<Apple> greenApple = FilterApple.filterGreenApple(appleBasket);
		for (Apple greenapple : greenApple) {
			System.out.println(greenapple);
		}
		
		System.out.println("--------원하는 사과 필터-----------");
		List<Apple> redApples = FilterApple.filterAppleByColor(appleBasket, RED);
		for (Apple redApple : redApples) {
			System.out.println(redApple);
		}
		
		System.out.println("---------------");
		
//		FilterApple.filterApple(appleBasket, new LightApplePredicate());
//		for (Apple apple : lightApples) {
//			System.out.println(apple);
		
		
		List<Apple> apples = FilterApple.filterApple(appleBasket, new ApplePredicate() {
			@Override
			public boolean test(Apple apple) {
				return apple.getColor() == RED || apple.getColor() == YELLOW;
			}
		});
		
		for (Apple apple : apples) {
			System.out.println(apple);
		}
		
		// 녹색이면서 100g 이하인 사과만 필터링
		// 우리는 이제 익명클래스를 통해, 새 클래스 파일 생성 없이 즉석에서 보낼 수 있다!
		// 근데... 어짜피 인터페이스에 추상메서드 하나 아니냐?
		// 그럼 이름을 굳이 언급할 필요 있나? -> 람다식 쓰자!
		
		List<Apple> apples2 = FilterApple.filterApple(appleBasket,
				apple -> apple.getColor() == RED && apple.getWeight() <= 100
		);
		
		for (Apple apple : apples2) {
			System.out.println(apple);
		}
		
		System.out.println("--------------------------");
		
		List<Apple> apples3 = FilterApple.filterApple(appleBasket,
				apple -> ((apple.getColor() == RED || apple.getColor() == GREEN) && apple.getWeight() > 150));
		
		for (Apple apple : apples3) {
			System.out.println(apple);
		}
	}
	
	
	
	
	
	
}
