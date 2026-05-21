package oop.stream.domain;

import oop.stream.exception.InvalidActivityException;

import java.util.HashSet;
import java.util.Set;

public abstract class LearningActivity {
    
    private static int totalCreateCount = 0;
    
    private final long id;
    public boolean needReview;
    private String titles;
    private int minutes;
    private Visibility visibility;
    private final ActivityCategory category;
    private final Set<String> tags = new HashSet<>();
    
    
    
    
//    public LearningActivity(String titles, int minutes) {
//
//        this(titles, minutes, Visibility.PUBLIC);
//    }
    
    public LearningActivity(String titles, int minutes, Visibility visibility, ActivityCategory category) {
        validateTitle(titles);
        validateMinutes(minutes);
        totalCreateCount++;
        this.id = totalCreateCount;
        this.titles = titles.trim(); //좌우 공백 제거.
        this.minutes = minutes;
        this.visibility = visibility;
        this.category = category;
    }
    
    public static int getTotalCreatedCount() {
        return totalCreateCount;
    }
    
    
    public void extendStudy(int additionalMinutes) {
        if  (additionalMinutes <= 0) {
            throw new InvalidActivityException(
                    "Additional minutes must be positive" + additionalMinutes);
        }
        this.minutes += minutes;
    }
    
    public void addTag(String tag) {
        if (tag == null || tag.isEmpty()) {
            throw new oop.collection.exception.InvalidActivityException("Empty Blank");
        }
        tags.add(tag.trim().toLowerCase());
    }

    
    public void changeTitles(String newTitles) {
        validateTitle(newTitles);
        this.titles = newTitles;
    }
    
   
    private void validateTitle(String newTitles) {
        if (newTitles == null || newTitles.isEmpty()) {
            throw new InvalidActivityException("비울 수 없음.");
        }
    }
    
    private void validateMinutes(int newMinutes) {
        if (newMinutes <= 0) {
            throw new InvalidActivityException("1분 이상" + newMinutes);
        }
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
