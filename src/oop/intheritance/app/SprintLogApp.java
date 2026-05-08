package oop.intheritance.app;

import oop.intheritance.domain.LearningActivity;
import oop.intheritance.domain.LectureLog;
import oop.intheritance.domain.PracticeLog;

public class SprintLogApp {
	public static void main(String[] args) {
		
		LearningActivity javaLecture = new LectureLog("Java 객체지향", 50, true, "박코치");
		PracticeLog gitPractice = new PracticeLog("Git 브랜치 실습", 70, true, 80);
		PracticeLog oopPractice = new PracticeLog("캡슐화 리팩터링", 40, false, 45);
		
		
		LectureLog lec = (LectureLog) javaLecture;
		
		
		// 다형성
		LearningActivity[] logs = {javaLecture, gitPractice, oopPractice};
		
		for (LearningActivity log : logs) {
			log.printSummary();
		}
		
		System.out.println("====== 복습 필요 =======");
		for (LearningActivity log : logs) {
			if (log.needReview()) {
				log.printSummary();
			}
		}
		
		
		System.out.println();
		System.out.println("====== 실습 ======");
		for (LearningActivity log : logs) {
			// 좌항 객체가 우항의 타입을 가질 수 있는가? 가능 true, 불가능 false
			if (log instanceof PracticeLog practiceLog) {
				System.out.println(practiceLog.getTitles() + " rate" + practiceLog.getCompletionRate() + "%");
				//System.out.println(log.getTitles() + " rate" + ((PracticeLog)log).getCompletionRate() + "%");
			}
			
			
		}
		
	}
}
