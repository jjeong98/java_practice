package oop.enum_exception.exception;

public class TryCatchExample {
	
	public static void main(String[] args) {
		
		try { //try 블록에는 예외 발생 가능성이 있는 코드를 배치.
			int i = 20, j = 0;
			
			System.out.println( i + "/" + j + " = " + (i/j));
			
			
		} catch (Exception e) {
			//CATCH 블록에는 try에서 실제 예외가 발생한 경우.
			// 실행할 내용을 작성.
			
			
			
			
		}
		System.out.println("Close");
	}
}
