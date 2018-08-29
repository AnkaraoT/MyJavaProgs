package com.myjava.prog;

public class StringEmptyTest {

	@SuppressWarnings("null")
	public static void main(String[] args) {
		String managedFileID=null;
	
		if(managedFileID!=null && managedFileID.trim().isEmpty()) {
			System.out.println(" managedFileID.isEmpty() "); 
		}

	}

}
