package com.capg.inventorymgmtsystem.excpetions;

public class InvalidVendorIdException extends RuntimeException {
	public InvalidVendorIdException(String msg) {
		super(msg);
	}
}
