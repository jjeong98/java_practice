package oop.constructor;

public class LearningLog {

    // 객체의 속성을 필드(field)
    String titles;
    int minutes;
    boolean publicLog;

    // 생성자는 클래의 이름과 대/소문자까지 완전히 일치.
    // 그리고 리턴 타입이 존재하지 않음.
    
    LearningLog() {
        System.out.println("기본 생성자 호출");
    }
    
    //생성자는 중복 선언이 가능함. Overloading
    //이름이 같아서 값의 개수, 순서, 타입을 다르게 작성해야지 중복 선언 인정.
    LearningLog(String titles, int minutes) {
        this(titles, minutes, true);
    }
    
    // 생성자는 메서드처럼 매개값을 전달 받을 수 있다.
    // 전달받은 값을 이용해서 필드를 초기화 할 수 있다.
    LearningLog(String titles, int minutes, boolean publicLog) {
        //this 객체는 현재 생성자의 객체를 불러오게 할 수 있는 객체.
        //필드와 생성자의 매개변수 이름이 동일할 경우 this로 구분을 지어줘야 함.
        //매개값이 있을 때, this를 사용함.
        this.titles = titles;
        this.minutes = minutes;
        this.publicLog = publicLog;
    }
    

    void printSummary() {
        System.out.println(titles + " - " + minutes + "Mins");
    }

    boolean needReview() {
        return minutes < 60;
    }


}
