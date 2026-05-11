package oop.inner_anonymous.app;

import oop.inner_anonymous.domain.*;
import oop.inner_anonymous.exception.InvalidActivityException;
import oop.inner_anonymous.printer.ActivityPrinter;
import oop.inner_anonymous.printer.ConsoleActivityPrinter;

public class SprintLogApp {
	public static void main(String[] args) {
		
		// ── 1. 기본 활동 목록 ──────────────────────────────────────────
		LearningActivity[] activities = {
				new LectureLog("Java enum 기초", 50, Visibility.PUBLIC, "박코치"),
				new PracticeLog("예외 처리 실습", 80, Visibility.PUBLIC, 90),
				new ReadingLog("객체지향의 사실과 오해", 35, Visibility.PRIVATE, "조영호")
		};
		
		// ── 2. 정적 중첩 클래스 시연 : Summary ──────────────────────────────────────────
		// static 중첩에서는 new로 굳이 안 적어도 상관없다.
		
		
		
	}
	
	
}
