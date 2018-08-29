package com.myjava.prog;
import java.util.Optional;

public class OptionalTest {

	public static void main(String[] args) {
		
		String name = null;
		
		System.out.println(Optional.of(name).get());

		
		Optional.ofNullable(name).orElseThrow(()->new RuntimeException());
	}

}
