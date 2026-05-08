package oop.abstract_interface.domain;

import oop.abstract_interface.policy.Reviewable;
import oop.abstract_interface.policy.Shareable;

import java.io.Serializable;

public class ReadingLog extends LearningActivity implements Reviewable, Shareable {
	
	private String bookTitle;
	
	public ReadingLog(String titles, int minutes, boolean publicActivity, String bookTitle) {
		super(titles, minutes, publicActivity);
		this.bookTitle = bookTitle;
	}
	
	@Override
	public void printSummary() {
			System.out.println("[독서] #" + getId() + " " + getTitles() + " - " + getMinutes() + "분 - 강사: " + bookTitle);
	}
	
	
	@Override
	public boolean needReview() {
		return getMinutes() < 45;
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
