package oop.static_final;

import java.time.LocalDateTime;

public class SprintLogApp {
	public static void main(String[] args) {
		
		LearningLog javaLog = new LearningLog("시작", 40);
		LearningLog gitLog = new LearningLog("복습", 30, false);
		LearningLog encapLog = new LearningLog("캡슐화", 90);
		
		LearningLog[] logs  = {javaLog, gitLog, encapLog};
		
		for (LearningLog log : logs) {
			log.printSummary();
		}
		
		
		System.out.println("=================================");
		
		// static 변수나 메서드는 객체마다 가지고 있는 값이 아님.
		// 값을 참조 할 때 선언된 클래스의 이름으로 참조.
		System.out.println("객체가 생성된 횟수" + LearningLog.getTotalCreateCount());
	}
}
