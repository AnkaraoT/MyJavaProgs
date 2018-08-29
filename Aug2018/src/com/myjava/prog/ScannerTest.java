package com.myjava.prog;
import java.util.Scanner;

public class ScannerTest {

	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		
		int i = sc.nextInt();
		double d = sc.nextDouble();	 
		//sc.useDelimiter(" ");
		String s = sc.next();	
		s = s+sc.nextLine();
		//sc.useDelimiter("\n");
		
		System.out.println("S : "+s);
		System.out.println("d : "+d);
		System.out.println("i : "+i);
	}

}
