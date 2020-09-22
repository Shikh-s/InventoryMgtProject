package com.capg.inventorymgmtsystem.excpetions;

/**
 * Invalid_Product_Id_Exception Class
 * @author Piyush
 *
 */
public class InvalidProductIdException extends RuntimeException{

	public InvalidProductIdException(String msg) {
		super(msg);
	}
}
