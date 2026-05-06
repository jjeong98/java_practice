package loop;

public class LoopNesting {


    public static void main(String[] args) {

        // 30 - 100 소수 찾기
        int total = 0;

        for (int i = 30; i <= 100 ; i++) {
            int count = 0; // i가 바뀔 때마다 새로 세야 하기 때문.

            for (int j = 1; j <= i; j++) {
                if (i % j == 0) {
                    count++;
                }
            }
            if (count == 2) {
                total++;
            }
        }

        System.out.println(total);
    }
}
