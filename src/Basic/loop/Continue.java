package Basic.loop;

public class Continue {

    public static void main(String[] args) {

        for (int i = 1; i <= 10; i++) {
            // for문에서 continue는 '증감식'이 실행이 된다.
            // while문에서도 가능하지만, "조건식"식이 실행이 됨
            if (i == 5) continue;

            System.out.print(i+ " ");
        }

        System.out.println("\n=========================================================");

        int n = 1;
        while (n <= 10) {
            if (n == 5) continue;
            System.out.print(n+ " ");
            n++;
        }

        System.out.println("\n반복문 종료");
    }
}
