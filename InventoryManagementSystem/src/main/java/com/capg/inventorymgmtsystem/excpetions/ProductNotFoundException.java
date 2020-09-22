package com.capg.inventorymgmtsystem.excpetions;

/**
 * Product_Not_Found_Exception class
 * @author Piyush
 *
 */
public class ProductNotFoundException extends RuntimeException{

	public ProductNotFoundException(String msg) {
		super(msg);
	}
}
