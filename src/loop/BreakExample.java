package loop;

public class BreakExample {

    public static void main(String[] args) {


        for (int i = 1; i <= 10; i++) {
            //블록 내의 코드가 한 줄인 경우 괄호 생략 가능.
            if (i == 5) break;
            System.out.print(i+ " ");
        }

        System.out.println("\n=========================================================");



    }
}
