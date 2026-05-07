package oop.intro;//객체 생성을 위한 설계도 클래스는 main 메서드를 사용하지 않는다.

public class LearningLog {

    // 객체의 속성을 필드(field)
    String titles;
    int minutes;
    boolean publicLog;


    void printSummary() {
        System.out.println(titles + " - " + minutes + "Mins");
    }

    boolean needReview() {
        return minutes < 60;
    }


}
