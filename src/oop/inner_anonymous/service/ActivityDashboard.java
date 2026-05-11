package oop.inner_anonymous.service;

import oop.inner_anonymous.domain.LearningActivity;

import java.util.Locale;

public class ActivityDashboard {
	
	private final LearningActivity[] activities;
	
	public ActivityDashboard(LearningActivity[] activities) {
		this.activities = activities;
	}
	
	/**
	 * 카테고리별 활동 수를 세어 정리를 만들자
	 * @return
	 */
	public Summary summarize() {
		//로컬 클래스 선언: summarize() 밖에서 사용할 수없음.
		
		class  Counter {
			private int totalCount;
			private int lectureCount;
			private int practiceCount;
			private int readingCount;
			
			void add(LearningActivity activity) {
				totalCount++;
				// getCategory()는 LearningActivity의 public API
				switch (activity.getCategory()) {
					case LECTURE  -> lectureCount++;
					case PRACTICE -> practiceCount++;
					case READING  -> readingCount++;
				}
			}
			
			Summary toSummary() {
				return new Summary(totalCount, lectureCount, practiceCount, readingCount);
			}
		} //end Counter Class
		
		Counter counter = new Counter();
		for (LearningActivity activity : activities) {
			counter.add(activity);
		}
		return counter.toSummary();
		
		
		
		
	} // end summarize()
	
	// 메모리 누수를 방지하고 static을 붙이는 이유 - 독립성을 가지기 위해사 (내부클래스)
	public static class Summary {
		
		private final int totalCount;
		private final int lecturerCount;
		private final int practiceCount;
		private final int readingCount;
		
		public Summary(int totalCount, int lecturerCount, int practiceCount, int readingCount) {
			this.totalCount = totalCount;
			this.lecturerCount = lecturerCount;
			this.practiceCount = practiceCount;
			this.readingCount = readingCount;
		}
		
		public int getTotalCount() {
			return totalCount;
		}
		
		public int getLecturerCount() {
			return lecturerCount;
		}
		
		public int getPracticeCount() {
			return practiceCount;
		}
		
		public int getReadingCount() {
			return readingCount;
		}
	}
	
	
	
}
