package oop.collection.domain;

import oop.collection.exception.InvalidActivityException;

import java.util.Collections;
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
    
    /**
     * 태그를 추가한다. 공백은 제거하고, 소문자로 저장한다.
     * 중복 태그는 무시한다. (Set의 특성)
     */
    public void addTag(String tag) {
        if (tag == null || tag.isEmpty()) {
            throw new InvalidActivityException("Empty Blank");
        }
        tags.add(tag.trim().toLowerCase());
    }
    
    /**
     * 등록된 태그 목록을 읽기 전용으로 반환한다.
     *
     */
    public Set<String> getTags() {
        return Collections.unmodifiableSet(tags);
    }
    
    /**
     * 해당 태그가 등록되어 있는지 확인한다.
     * @return
     */
    public boolean hasTag(String tag) {
        if (tag == null) return false;
        return tags.contains(tag.trim().toLowerCase());
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
