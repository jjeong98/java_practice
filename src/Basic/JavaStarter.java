package Basic;

public class JavaStarter {

    public static void main(String[] args) {
        // 출력 함수 : sout
        System.out.println("Hello World!");

        String title = "문자열 자료형 + 변수";
        int studyMin = 90;
        int studyMax = 120;
        int extraMin = 30;

        studyMin = 120;

        boolean isPublic = false;

        // 자바에서는 int + int = int
        // 소수점을 표현하고 싶으면 연산하고자는 값의 타입을 실수형(double)로 바꿔야 한다.
        double progressRate = (double)studyMin / studyMax;

        boolean isEnough =  studyMin >= 60;

        System.out.println(title);
        System.out.println(studyMin);
        System.out.println(studyMax);
        System.out.println(extraMin);
        System.out.println(progressRate);
        System.out.println(isPublic);
        System.out.println(isEnough);




    }
}
