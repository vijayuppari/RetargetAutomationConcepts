package com.retarget.Methodchaining;

public class Login {
	
	public Home_chain1 logs(){
		System.out.println("I am in Login Page");
		return new Home_chain1();
	}

}
