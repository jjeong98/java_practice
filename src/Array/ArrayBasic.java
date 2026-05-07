package Array;

import java.util.Arrays;

public class ArrayBasic {

    public static void main(String[] args) {

        // 1. 배열 변수 선언
        int[] numbers;

        // 2. 배열 객체 생성
        numbers = new int[5];

        // 3. 배열 내부 초기화
        // index는 0부터 시작.
        numbers[0] = 50;
        numbers[1] = 77;
        numbers[2] = (int) 3.14; // int로 바뀌었기 때문에 소수점이 버려짐.
        numbers[3] = numbers[0] + 20;
//        numbers[4] = numbers[1] + 20;
        numbers[4] = numbers[1] + 20;
//        numbers[5] = numbers[2] + 20;

        //4. 배열의 길이
        System.out.println("배열의 길이: " + numbers.length);

        //5. 배열의 순회
        for (int i = 0; i < numbers.length; i++) {
            System.out.println((i+1) + "번째 값 :" + numbers[i]);

        }

        System.out.println("+=================================");

        // 배열의 순회 forEach (향상된 for문)
        // *배열의 처음부터 끝까지로 설정이 됨. (중간에 break/ continue 가능)
        for (int i : numbers) {
            System.out.println(i);
        }


        //배열 내부를 문자열 형태로 한 번에 출력하기
        System.out.println(Arrays.toString(numbers));


        //배열 쉽게 초기화하기
        int[] pointList = {1,2,3,4,5};

        //배열 선언 당시에 크기가 고정이 되어서 그 변수의 크기는 변하기 위해선 새롭게 정의를 해 줘야 함.
        String[] pets = {"1", "2", "3", "4", "5"};
        pets = new String[]{"1", "2", "3", "4"};
    }


}
