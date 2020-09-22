package com.capg.inventorymgmtsystem.exceptions;

public class OutOfStockException extends RuntimeException {
	public OutOfStockException(String msg) {
		super(msg);
	}
}
