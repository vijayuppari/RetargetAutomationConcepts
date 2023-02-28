package com.retarget.Methodchaining;

public class MethodChaining {
	
	public MethodChaining print(){
		System.out.println("Print Hello");
		return this; // or we can use return this 
	}
	
	public MethodChaining Age(){
		System.out.println("Printing Age");
		return this; // or we can use return this
	}
	
	public static void main(String[] args) {
		
		MethodChaining methodchain = new MethodChaining();
		methodchain.print().Age();
		
	}

}
