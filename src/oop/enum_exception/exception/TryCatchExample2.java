package oop.enum_exception.exception;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TryCatchExample2 {
	public static void main(String[] args) {
		
		try {
			Scanner sc = new Scanner(System.in);
			int[] arr = new int[5];
			
			System.out.println("정수 :");
			int n = sc.nextInt();
			
			int result = 100/n;
			System.out.println( arr[result] );
			
			String s = null;
			s.equals("메롱");
		} catch (InputMismatchException | ArithmeticException e) {
			System.out.println("입력값 잘못");
		}  catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Out of Index");
		} catch (NullPointerException e) {
			System.out.println("Null X");
		} catch (Exception e) {
			System.out.println("Exception");
		} finally {
			System.out.println( "Blah");
			
		}
		
		
	}
}
