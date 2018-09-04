package com.myjava.prog.java8.fetures.lamda;

public class LamdaPrg3 {

	
	public static void main(String[] args) {
			
		Operation op1 = (x,y)->{return x+y;};
		System.out.println(op1.apply(34, 56));
		
		ArithmeticOperations c1 = (int x,int y,Operation op11)->{System.out.println("Result : "+op11.apply(x, y));};
		c1.cal(34, 78, op1);
		
		Operation op2 = (x,y)->{return x-y;};
		System.out.println(op2.apply(34, 56));
		
		ArithmeticOperations c2 = (int x,int y,Operation op22)->{System.out.println("Result : "+op2.apply(x, y));};
		c2.cal(34, 78, op2);
		
		
		Operation op3 = (x,y)->{return x/y;};
		System.out.println(op3.apply(34, 56));
		
		ArithmeticOperations c3 = (int x,int y,Operation op33)->{System.out.println("Result : "+op33.apply(x, y));};
		c3.cal(34, 78, op3);
		
		
		
		Operation op4 = (x,y)->{return x%y;};
		System.out.println(op4.apply(34, 56));
		
		ArithmeticOperations c4 = (int x,int y,Operation op44)->{System.out.println("Result : "+op44.apply(x, y));};
		c4.cal(34, 78, op4);
		
	}

}

@FunctionalInterface
interface Operation {
	public int apply(int a,int b);
}


@FunctionalInterface
interface ArithmeticOperations { // Arithmetic 
	public void cal(int a,int b,Operation op);
}


