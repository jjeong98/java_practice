package constate;

public class IfExample2 {

    public static void main(String[] args) {

        int age = 25;

        if (age >= 20) {
            if (age < 40) {
                System.out.println("청년");
            } else if (age >= 60) {
                System.out.println("장년");
            } else {
                System.out.println("노년");
            }
        } else if (age >= 17) {
            System.out.println("고등학생입니다.");
        } else if (age >= 14) {
            System.out.println("중학생입니다.");
        } else if (age >= 13) {
            System.out.println("초등학생");
        } else {
            System.out.println("미취학");
        }
    }
}
