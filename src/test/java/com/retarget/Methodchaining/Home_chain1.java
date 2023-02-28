package com.retarget.Methodchaining;

public class Home_chain1 {
	
	public Home_chain1 home(){
		System.out.println("I am in Home Page");	
		return this;
	}
	
	public Home_chain1 homeAfter(){
		System.out.println("I am out of Home");	
		return this;
	}

}
