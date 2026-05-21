package oop.stream.domain;

import oop.stream.policy.Reviewable;
import oop.stream.policy.Shareable;

// LectureLog느 LearningActivity의 한 좋류이고, Reviewable 선언된 역할을 수행 가능
public class LectureLog extends LearningActivity implements Reviewable, Shareable {
	
	private String instructorName;
	
	public LectureLog(String titles, int minutes, Visibility visibility, String instructorName) {
		super(titles, minutes, visibility, ActivityCategory.LECTURE);
		this.instructorName = normalizedInstructorName(instructorName);
		
	}
	
	@Override
	public boolean needReview() {
		return getCategory().isShortStudy(getMinutes());
	}
	
	private String normalizedInstructorName(String instructorName) {
		if (instructorName == null || instructorName.isBlank()){
			return "미정";
		}
		return instructorName;
	}
	
	@Override
	public void printReviewTarget() {
		System.out.println("복습" + getTitles() + " (" + getMinutes() + "분)");
	};
	
	@Override
	public boolean canShare() {
		return isPublicActivity();
	}
	
	@Override
	public String getShareTitle() {
		return getTitles();
	}
	
	@Override
	public String getActivityType() {
		return "강의";
	}
	
	@Override
	public String getDetailText() {
		return "강사 : " + instructorName;
	}
	
	
	public String getInstructorName() {
		return instructorName;
	}
}
