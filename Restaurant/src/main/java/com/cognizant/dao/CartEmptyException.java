package com.cognizant.dao;

public class CartEmptyException extends Exception {
	
	public CartEmptyException(String s)
	{
		System.out.println(s);
	}

}
