package oop.static_final;

public class LearningLog {
    // 상수는 대문자로 작성하는 것이 관례.
    // 상수는 고정된 불변의 값을 의미.
    // 모든 객체가 하나의 값을 공유.
    private static final int REVIEW_THRESHOLD_MINUTES = 60;
    
    //LeaningLog를 얼마나 생성했는지 확인한 객체
    private static int totalCreateCount = 0;
    
    private final long id;
    private String titles;
    private int minutes;
    private boolean publicLog;
    
    
    LearningLog(String titles, int minutes) {
        
        this(titles, minutes, true);
    }
    
    LearningLog(String titles, int minutes, boolean publicLog) {
        totalCreateCount++;
        this.id = totalCreateCount;
        this.titles = normalizeTitle(titles);
        this.minutes = minutes;
        this.publicLog = publicLog;
    }
    
  
    public void setMinutes(int minutes) {
        if  (minutes <= 0) {
            System.out.println("잘못");
            return;//   void 메서드에서 return 메서드는 강종.
        }
        this.minutes += minutes;
    }

    
    public void changeTitles(String newTitles) {
        
        this.titles = normalizeTitle(newTitles);
    }
    
   
    private String normalizeTitle(String newTitles) {
        if (newTitles == null && newTitles.isEmpty()) {
        return "No title";
        }
        return newTitles;
    }
    
    public void openToPublic() {
        this.publicLog = true;
    }
    public void hideFromPublic() {
        this.publicLog = false;
    }
    
    
    void printSummary() {
        String visibility = publicLog ? " OPEN" : " HIDE";
        
        System.out.println("#" +  id + ". " + this.titles + " - " + this.minutes + " Mins" + visibility);
    }

    boolean needReview() {
        return minutes < REVIEW_THRESHOLD_MINUTES;
    }
    
    public static int getTotalCreateCount() {
        return totalCreateCount;
    }
    
    public String getTitles() {
        return titles;
    }
    
    public int getMinutes() {
        return minutes;
    }

    public boolean isPublicLog() {
        return publicLog;
    }
}
