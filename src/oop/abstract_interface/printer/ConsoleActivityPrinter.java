package oop.abstract_interface.printer;

import oop.abstract_interface.domain.LearningActivity;

public class ConsoleActivityPrinter implements ActivityPrinter {
	
	@Override
	public void print(LearningActivity activity) {
		System.out.println(
				"[" + activity.getActivityType() + "]"
						+ " #" + activity.getId()
						+ " " + activity.getTitles()
						+ " - " + activity.getMinutes() + "분"
						+ " - " + activity.getDetailText()
						+ " - " + activity.getVisibilityText() + "🤮"
		);
	}




}
