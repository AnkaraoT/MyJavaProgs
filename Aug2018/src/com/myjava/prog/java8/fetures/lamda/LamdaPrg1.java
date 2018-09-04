package com.myjava.prog.java8.fetures.lamda;

@FunctionalInterface
interface interf{
	public void printMe();
}

public class LamdaPrg1 {

	/*public void printMe() {
		System.out.println("Print Me Method");
	}*/
	
	public static void main(String[] args) {
		//new FirstPrg().printMe();
		interf i = ()-> System.out.println("Print Me Method : ");
		i.printMe();
	}

}
