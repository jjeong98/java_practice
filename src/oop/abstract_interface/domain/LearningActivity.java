package oop.abstract_interface.domain;

public abstract class LearningActivity {
    
    private static int totalCreateCount = 0;
    
    private final long id;
    public boolean needReview;
    private String titles;
    private int minutes;
    private boolean publicActivity;
    
    
    
    public LearningActivity(String titles, int minutes) {
        
        this(titles, minutes, true);
    }
    
    public LearningActivity(String titles, int minutes, boolean publicActivity) {
        totalCreateCount++;
        this.id = totalCreateCount;
        this.titles = normalizeTitle(titles);
        this.minutes = minutes;
        this.publicActivity = publicActivity;
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
        this.publicActivity = true;
    }
    public void hideFromPublic() {
        this.publicActivity = false;
    }
    
    // 추상메서드는 메서드 바디가 없는 메서드의 틀 역할을 합니다.
    // 특정 메서드는 부모가 정하는 것보다 자식이 맞게 끔 구현하게 하는게 명확할 때가 있다.
    // 자식에게 물려줄 때 오버라이드를 "강제".
    public abstract void printSummary();
    
    public static int getTotalCreateCount() {
        return totalCreateCount;
    }
    
    public String getTitles() {
        return titles;
    }
    
    public int getMinutes() {
        return minutes;
    }

    public boolean ispublicActivity() {
        return publicActivity;
    }
    
    public long getId() {
        return id;
    }
}
