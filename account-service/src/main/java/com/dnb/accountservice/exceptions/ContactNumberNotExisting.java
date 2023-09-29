package com.dnb.accountservice.exceptions;

public class ContactNumberNotExisting extends Exception {
	
	public ContactNumberNotExisting(String msg) {
		super(msg);
	}
	
	@Override
	public String toString() {
		return super.toString()+ super.getMessage();
	}

}
