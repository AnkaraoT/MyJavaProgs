package com.myjava.prog.java8.fetures.lamda;

public class LamdaPrg2 {

	
	public static void main(String[] args) {
			
		Operator op1 = (x,y)->{return x+y;};
		op1.apply(34, 56);
		
		Calculate c = (int x,int y,Operator op2)->{op2.apply(x, y);};
		c.cal(34, 78, op1);
		
	}

}

@FunctionalInterface
interface Operator {
	public int apply(int a,int b);
}


@FunctionalInterface
interface Calculate{
	public void cal(int a,int b,Operator op);
}


