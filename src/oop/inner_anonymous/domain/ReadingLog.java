package oop.inner_anonymous.domain;

import oop.inner_anonymous.policy.Reviewable;
import oop.inner_anonymous.policy.Shareable;

public class ReadingLog extends LearningActivity implements Reviewable, Shareable {
	
	private String bookTitle;
	
	public ReadingLog(String titles, int minutes, Visibility visibility, String bookTitle) {
		super(titles, minutes, visibility, ActivityCategory.READING);
		this.bookTitle = bookTitle;
	}
	
	
	
	@Override
	public boolean needReview() {
		return getCategory().isShortStudy(getMinutes());
	}
	
	@Override
	public void printReviewTarget() {
		System.out.println("[복습 권장] " + getTitles() + " (" + bookTitle + ")");
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
