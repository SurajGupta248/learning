package com.encrypt;

abstract class Hello
{
  abstract void sayHello();
  public void text(){
	  System.out.println("text something");
  }
	
}
public class AnonoymousClassDemo {
	public static void main(String[] args) {
		new Hello(){
			public void sayHello(){
				System.out.println("Hello");
			}
			public void text(){
				System.out.println("Inside anonymous class");
			}
		}.text();
		
	}
      
}
