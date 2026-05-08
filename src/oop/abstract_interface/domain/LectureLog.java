package oop.abstract_interface.domain;

import oop.abstract_interface.policy.Reviewable;
import oop.abstract_interface.policy.Shareable;

// LectureLog느 LearningActivity의 한 좋류이고, Reviewable 선언된 역할을 수행 가능
public class LectureLog extends LearningActivity implements Reviewable, Shareable {
	
	private String instructorName;
	
	public LectureLog(String titles, int minutes, boolean publicActivity, String instructorName) {
		super(titles, minutes, publicActivity);
		this.instructorName = normalizedInstructorName(instructorName);
		
	}
	
	
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
	
	@Override
	public void printReviewTarget() {
		printSummary();
	}
	
	@Override
	public boolean canShare() {
		return ispublicActivity();
	}
	
	@Override
	public String getShareTitle() {
		return getTitles();
	}
}
