package com.myjava.prog;

public class TestOneStatic {

	static int a = 1111;
	
	static {
		a= a-- - --a;
		//a = 1111-1109=>2
	}
	
	{
		a=a++ + ++a;
		//a = 1 =>2 + 1=> 1
	}
	
	public static void main(String[] args) {
		System.out.println(a);
	}

}
