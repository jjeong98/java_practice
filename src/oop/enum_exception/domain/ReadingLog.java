package oop.enum_exception.domain;

import oop.enum_exception.policy.Reviewable;
import oop.enum_exception.policy.Shareable;

public class ReadingLog extends LearningActivity implements Reviewable, Shareable {
	
	private String bookTitle;
	
	public ReadingLog(String titles, int minutes, Visibility visibility, String bookTitle) {
		super(titles, minutes, Visibility.PUBLIC);
		this.bookTitle = bookTitle;
	}
	
	
	
	@Override
	public boolean needReview() {
		return getMinutes() < 45;
	}
	
	@Override
	public void printReviewTarget() {
		System.out.println("복습" + getTitles() + " (" + getMinutes() + "분)");
	}
	
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
		return "독서";
	}
	
	@Override
	public String getDetailText() {
		return "책" +bookTitle;
	}
}
