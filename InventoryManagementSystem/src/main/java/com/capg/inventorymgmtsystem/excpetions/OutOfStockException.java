package com.capg.inventorymgmtsystem.excpetions;

public class OutOfStockException extends RuntimeException {
	public OutOfStockException(String msg) {
		super(msg);
	}
}
