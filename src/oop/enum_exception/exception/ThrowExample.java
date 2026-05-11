package oop.enum_exception.exception;

public class ThrowExample {
	
	static int calcTotal(int end) throws Exception {
		if(end <= 0) {
			throw new Exception("blah");
			
		}
		
		int total = 0;
		for (int i = 1; i <= end ; i++) {
			total += i;
		}
		return total;
	}
	
	public static void main(String[] args) {
		
		try {
			int result = calcTotal(100);
			System.out.println("result = " + result);
			
			int result2 = calcTotal(-120);
			System.out.println("result = " + result2);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println("Fin");
	}
}
