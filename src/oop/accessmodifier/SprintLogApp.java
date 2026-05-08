package oop.accessmodifier;

public class SprintLogApp {
	public static void main(String[] args) {
		
		LearningLog javaLog = new LearningLog("시작", 40);
		LearningLog gitLog = new LearningLog("복습", 30, false);
		
//		javaLog.titles ="dfgdf";
//		javaLog.minutes =-60;
//		javaLog.publicLog =false; 접근 불가, 참조 불가 = private를 선언해서
		
		
		
		javaLog.changeTitles("java");
		javaLog.hideFromPublic();
		
		gitLog.openToPublic();
		
		javaLog.printSummary();
		gitLog.printSummary();
	}
}
