package oop.stream.printer;

import oop.stream.domain.LearningActivity;

public class CompactActivityPrinter implements ActivityPrinter {
	
	@Override
	public void print(LearningActivity activity) {
		System.out.println(
				activity.getActivityType()
						+ " | " + activity.getTitles()
						+ " (" + activity.getMinutes() + "분)"
		);
	}

}
