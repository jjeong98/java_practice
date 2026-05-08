package oop.intheritance.domain;

public class LectureLog extends LearningActivity {
	
	private String instructorName; // 강사 이름 - LectureLog만 가질 수 있는 고유 필드
	
	public LectureLog(String titles, int minutes, boolean publicActivity, String instructorName) {
		// 상속 관계 하에서 자식 객체가 생성될 때, 부모의 객체도 생성 (필드, 메서드를 물려 줄 수 있으니까)
		// 생성자에는 항상 super()가 내장.
		super(titles, minutes, publicActivity);
		this.instructorName = normalizedInstructorName(instructorName);
		
	}
	
	// 메서드 재정의 - override
	// 부모가 물려준 메서드가 자식에 맞지 않아서 재정의 해서 사용 가능.
	// 규칙 1. 메서드 이름이 같아야 함/ 2. 리턴 타입이 같아야 함./ 3. 매개뱐수의 선언이 일치해야 함.
	@Override
	public void printSummary() {
		System.out.println("[강의] #" + getId() + " " + getTitles() + " - " + getMinutes() + "분 - 강사: " + instructorName);
	}
	
	@Override
	public boolean needReview() {
		return getMinutes() < 60;
	}
	
	private String normalizedInstructorName(String instructorName) {
		if (instructorName == null || instructorName.isBlank()){
			return "미정";
		}
		return instructorName;
	}
	
}
