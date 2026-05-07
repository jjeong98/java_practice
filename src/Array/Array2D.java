package Array;

import java.util.Arrays;

public class Array2D {

    public static void main(String[] args) {


        //배열 선언 시, 인덱스 값이 비어있지는 않음
        //각 타입의 기본값으로 초기화
        // 0, 0.0. false, (공백), null
        int[][] array = new int[3][4];
        array[1][1] = 100;
        System.out.println(Arrays.deepToString(array));

        for (int[] a : array) {
            for (int i : a) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
