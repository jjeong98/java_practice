package oop.stream.domain;

import oop.stream.policy.Reviewable;
import oop.stream.policy.Shareable;

public class PracticeLog extends LearningActivity implements Reviewable, Shareable {
	
	private int completionRate;
	
	public PracticeLog(String titles, int minutes, Visibility visibility, int completionRate) {
		super(titles, minutes, visibility, ActivityCategory.PRACTICE);
		this.completionRate = normalizeCompletionRate(completionRate);
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
		return getCategory().isShortStudy(getMinutes()) || completionRate <70;
	}
	
	@Override
	public void printReviewTarget() {
	
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
		return "실습";
	}
	
	@Override
	public String getDetailText() {
		return "완료율 :" + completionRate + "%";
	}
}
