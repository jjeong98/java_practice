package oop.accessmodifier;

public class LearningLog {
    
    //접근 제한자를 활용한 정보 은닉과 캡슐화 ( info hiding, encapsulation)
    // 1. 필드에 private 접근 제한을 붙여 외부에서 직접 접근이 허용 불가.
    private String titles;
    private int minutes;
    private boolean publicLog;
    
    LearningLog() {
        System.out.println("기본 생성자 호출");
    }
    
    LearningLog(String titles, int minutes) {
        this(titles, minutes, true);
    }
    
    LearningLog(String titles, int minutes, boolean publicLog) {
        
        this.titles = normalizeTitle(titles);
        this.minutes = minutes;
        this.publicLog = publicLog;
    }
    
    
    // private 접근 제한을 지정하니 제대로 된 값도 수정이 불가능.
    // 필드값을 대신 받아서 할당, 값을 리턴하는 메서드로 값을 보호.
    // 이 때 사용하는 메서드 getter (값 얻을 때)/ setter (값 설정 할 때)
    // set + 필드 이름이 관례.
    
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
    
    // 이 메서드는 굳이 외부에서 알 필요가 없어서 private로 설정해서 이 클래스에서만 사용 할 수 있도록 지정.
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
        //3항 연산식: 조건식의 결과에 따라 변수에 대입할 값을 다르게 할 수 있는 문법
        // 논리형 조건식 ? 좌항:우할
        // 논리형 조건식이 true라면 좌항의 값, false라면 우항의 값.
        String visibility = publicLog ? "OPEN" : "HIDE";
        
        System.out.println(titles + " - " + minutes + "Mins");
    }

    boolean needReview() {
        return minutes < 60;
    }
    
    //외부로 필드값을 getter 메서드
    //get + 필드이름으로 지어주는 것이 관례.boolean 타입의 값을 돌려주는 getter는 is로 시작.
    
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
