package oop.intheritance.domain;

import Basic.constate.IfExample;

public class PracticeLog extends LearningActivity {
	
	private int completionRate;
	
	public PracticeLog(String titles, int minutes, boolean publicActivity, int completionRate) {
		super(titles, minutes, publicActivity);
		this.completionRate = normalizeCompletionRate(completionRate);
	}
	
	@Override
	public void printSummary() {
		System.out.println("[실습] #" + getId() + " " + getTitles() + " - " + getMinutes() + "분 - 완료율: " + completionRate);
	}
	
	@Override
	public boolean needReview() {
		return getMinutes() < 60 || completionRate < 70;
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
	
}
