package com.rest.threads;

public class ThreadLocalExampes {
	
	public static void main(String[] args) {
		
		
		ThreadLocal threadlocal= new ThreadLocal();
		threadlocal.set("Vijay");
		System.out.println(threadlocal.get());
		
		ThreadLocal threadlocal2= ThreadLocal.withInitial(()-> "Nani");

		System.out.println(threadlocal2.get());
		
	}

}
