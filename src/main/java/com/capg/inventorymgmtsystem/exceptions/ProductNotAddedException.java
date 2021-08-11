package com.capg.inventorymgmtsystem.exceptions;

/**
 * Product_Not_Added_Exception class
 * @author Piyush
 *
 */
public class ProductNotAddedException extends RuntimeException{

	public ProductNotAddedException(String msg) {
		super(msg);
	}
}
