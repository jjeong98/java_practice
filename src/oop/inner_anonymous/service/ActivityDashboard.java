package oop.inner_anonymous.service;

import oop.inner_anonymous.domain.LearningActivity;
import oop.inner_anonymous.printer.ActivityPrinter;

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
		
		public int getLectureCount() {
			return lecturerCount;
		}
		
		public int getPracticeCount() {
			return practiceCount;
		}
		
		public int getReadingCount() {
			return readingCount;
		}
		/**
		 * 보고서 출력기
		 * 외부 클래스(ActivityDashboard)가 가지고 있는 activities 배열에 접근 해야 하기 때문에
		 * static을 붙이지 않은 멤버 내부 클래서로 선언
		 */
		
		public class ReportBuilder {
			
			private final ActivityPrinter printer;
			
			public ReportBuilder(ActivityPrinter printer) {
				if (printer == null) {
					throw new IllegalArgumentException("printer cannot be null");
				}
				this.printer = printer;
			}
			
			public void  print() {
				Summary summary = summarize();  // 외부 클래스의 summarize() 호출
				System.out.println("── 활동 수: 총 " + summary.getTotalCount()
						+ "개 (강의 " + summary.getLectureCount()
						+ " / 실습 " + summary.getPracticeCount()
						+ " / 독서 " + summary.getReadingCount() + ")");
				
				for (LearningActivity activity : activities) {  // 외부 클래스의 activities 접근
					printer.print(activity);
				}
			}
			
		}
		
		
		
		
		
	}
	
	
	
}
