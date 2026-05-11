package oop.enum_exception.domain;

public abstract class LearningActivity {
    
    private static int totalCreateCount = 0;
    
    private final long id;
    public boolean needReview;
    private String titles;
    private int minutes;
    private Visibility visibility;
    private final ActivityCategory category;
    
    
    
    
//    public LearningActivity(String titles, int minutes) {
//
//        this(titles, minutes, Visibility.PUBLIC);
//    }
    
    public LearningActivity(String titles, int minutes, Visibility visibility, ActivityCategory category) {
        totalCreateCount++;
        this.id = totalCreateCount;
        this.titles = normalizeTitle(titles);
        this.minutes = minutes;
        this.visibility = visibility;
        this.category = category;
    }
    
  
    public void setMinutes(int minutes) {
        if  (minutes <= 0) {
            System.out.println("잘못");
            return;
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
        this.visibility = Visibility.PUBLIC;
    }
    public void hideFromPublic() {
        this.visibility = Visibility.PRIVATE;
    }
    
    public abstract  String getActivityType();
    public abstract  String getDetailText();
    
    public static int getTotalCreateCount() {
        return totalCreateCount;
    }
    
    public String getTitles() {
        return titles;
    }
    
    public int getMinutes() {
        return minutes;
    }

    public Visibility getVisibility() {
        return visibility;
    }
    
    public long getId() {
        return id;
    }
    
    public String getVisibilityText() {
        return this.visibility.getLabel();
    }
    
    public boolean isPublicActivity() {
        return visibility == Visibility.PUBLIC;
    }
    
    public ActivityCategory getCategory() {
        return category;
    }
}
