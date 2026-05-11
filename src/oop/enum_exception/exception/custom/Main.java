package oop.enum_exception.exception.custom;

import java.sql.SQLOutput;

public class Main {
	public static void main(String[] args) {
		
		
		
		LoginUser user = new LoginUser("abc123","asdf1234");
		String result = null;
		try {
			result = user.authenticate("abc123", "asdf1234");
		} catch (LoginInvalidException e) {
			System.out.println(e.getMessage());
			System.out.println("Input Value" + e.getInputAccount());
			
		}
		
		System.out.println("result = " + result);
	}
}
