package loop;

public class WhileExample {

    public static void main(String[] args) {

        // 반복문의  필수 3요소 (begin - end - step)

        int i = 1; //변수명/ 변수까지 할당하는 시작점.
        while (i <= 10) { //i에 대한 끝점
            System.out.println("Hi " + i + " Welcome");
//            i += 1; //i 증가에 대한 방식을 적기
            i++;
        }

        // for (시작값; 끝값; 방법)
        for (int j = 1; j<=10; j++) {
            System.out.println("Hello " + j + " Welcome");

        }
            System.out.println("====================================================");

        //1-100 누적합계

        int k = 1;
        int total = 0;
        while (k <= 100) {
            total += k;
            k++;
        }
            System.out.println("Total is " + total);

        int result = 0;
        for (int m = 1; m<=100; m++) {
            result += m;
        }

        //소수 판별
        int num = 413;
        int n = 1;
        int count = 0;

        while (n <= num) {
            if (num % n == 0) {
                count++;
            }
            n++;
        }

        int s = 2;
        while (num % s != 0) {
            s++;
        }
        if ( num == s) {
            System.out.println(num + " 소수");
        } else {
            System.out.println(num + " 노 소수");
        }
    }
}