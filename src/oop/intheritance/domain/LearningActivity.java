package oop.intheritance.domain;

public class LearningActivity {
    
    private static final int REVIEW_THRESHOLD_MINUTES = 60;
    
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
    
    
    public void printSummary() {
        String visibility = publicActivity ? " OPEN" : " HIDE";
        
        System.out.println("#" +  id + ". " + this.titles + " - " + this.minutes + " Mins" + visibility);
    }

    public boolean needReview() {
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

    public boolean ispublicActivity() {
        return publicActivity;
    }
    
    public long getId() {
        return id;
    }
}
