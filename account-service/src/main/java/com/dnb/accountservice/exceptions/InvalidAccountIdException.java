package com.dnb.accountservice.exceptions;

public class InvalidAccountIdException extends Exception{
	
	public InvalidAccountIdException(String msg) {
		super(msg);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return super.toString() + super.getMessage();
	}

}
