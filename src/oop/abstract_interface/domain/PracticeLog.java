package oop.abstract_interface.domain;

import oop.abstract_interface.policy.Reviewable;
import oop.abstract_interface.policy.Shareable;

import java.io.Serializable;

public class PracticeLog extends LearningActivity implements Reviewable, Shareable {
	
	private int completionRate;
	
	public PracticeLog(String titles, int minutes, boolean publicActivity, int completionRate) {
		super(titles, minutes, publicActivity);
		this.completionRate = normalizeCompletionRate(completionRate);
	}
	
	@Override
	public void printSummary() {
		System.out.println("[실습] #" + getId() + " " + getTitles() + " - " + getMinutes() + "분 - 완료율: " + completionRate);
	}
	
	public int getCompletionRate() {
		return completionRate;
	}
	
	private int normalizeCompletionRate(int completionRate) {
		if  (completionRate < 0) {
			return 0;
		}
		if (completionRate > 100) {
			return 100;
		}
		return completionRate;
	}
	
	@Override
	public boolean needReview() {
		return getMinutes() < 60;
	}
	
	@Override
	public void printReviewTarget() {
	
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
