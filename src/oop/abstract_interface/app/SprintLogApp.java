package oop.abstract_interface.app;

import oop.abstract_interface.domain.LearningActivity;
import oop.abstract_interface.domain.LectureLog;
import oop.abstract_interface.domain.PracticeLog;
import oop.abstract_interface.domain.ReadingLog;
import oop.abstract_interface.policy.Reviewable;
import oop.abstract_interface.policy.Shareable;

public class SprintLogApp {
	public static void main(String[] args) {
		
		LectureLog javaLecture = new LectureLog("Java 객체지향", 50, true, "박코치");
		PracticeLog gitPractice = new PracticeLog("Git 브랜치 실습", 70, true, 80);
		PracticeLog oopPractice = new PracticeLog("캡슐화 리팩터링", 40, false, 45);
		ReadingLog oopBook = new ReadingLog("객체지향의 사실과 오해", 35, true, "객체지향의 사실과 오해");
		
		
		// 추상 클래스는 스스로의 객체 생성 할 수 없고, 자식의 구현에 의해서만 생성 가능.
		//LearningActivity act = new LearningActivity("test", 10);
		
		LearningActivity[] activities = {javaLecture, gitPractice, oopPractice, oopBook};
		
		System.out.println("=== 학습 활동 목록 ===");
		for (int i = 0; i < activities.length; i++) {
			activities[i].printSummary();
		}
	
		// 다형성이랑 부모 타입의 변수에 자시 타입ㅢ 객체가 들어올 수 있는 것 = 상속 관계에서만 발생
		// 인터페이스 구현 관계도 다형성이 발생이 가능함.
		
		Reviewable[] reviewables = {javaLecture, gitPractice, oopPractice, oopBook};
		System.out.println();
		System.out.println("복습");
		for (Reviewable reviewable : reviewables) {
			if (reviewable.needReview()) {
				reviewable.printReviewTarget();
			}
		}
		
		Shareable[] shareables = {javaLecture, gitPractice, oopPractice, oopBook};
		
		System.out.println();
		System.out.println("=== 공유 가능한 활동 ===");
		for (Shareable shareable : shareables) {
			if (shareable.canShare()) {
				System.out.println(shareable.getShareTitle());
			}
		}
	
	}
}
