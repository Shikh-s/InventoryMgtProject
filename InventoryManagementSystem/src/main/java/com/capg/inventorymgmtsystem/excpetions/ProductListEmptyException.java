package com.capg.inventorymgmtsystem.excpetions;

/**
 * Product_List_Empty_Exception Class
 * @author Piyush
 *
 */
public class ProductListEmptyException extends RuntimeException{

	public ProductListEmptyException(String msg) {
		super(msg);
	}
}
