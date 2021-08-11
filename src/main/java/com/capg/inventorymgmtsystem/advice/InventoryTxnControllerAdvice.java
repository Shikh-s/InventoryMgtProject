package com.capg.inventorymgmtsystem.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.capg.inventorymgmtsystem.exceptions.InvalidProdIdException;
import com.capg.inventorymgmtsystem.exceptions.InvalidVendorIdException;
import com.capg.inventorymgmtsystem.exceptions.OutOfStockException;
import com.capg.inventorymgmtsystem.exceptions.VendorListEmptyException;
import com.capg.inventorymgmtsystem.exceptions.WrongVendorTypeException;

/**
 * Inventory Transaction Advice Class 
 * Exceptions are handled
 * 
 * @author Shikhar
 *
 */
@RestControllerAdvice
public class InventoryTxnControllerAdvice {
	
	/**
	 * Out_Of_Stock exception handler method
	 * 
	 * @param e
	 * @return exception message and status code
	 */
	@ExceptionHandler(OutOfStockException.class)
	public ResponseEntity<String> handleOutOfStockException(OutOfStockException e){
		return new ResponseEntity<String>(e.getMessage(),HttpStatus.NOT_FOUND);
	}
	
	/**
	 * Invalid_Vendor_Id exception handler method
	 * 
	 * @param e
	 * @return exception message and status code
	 */
	@ExceptionHandler(InvalidVendorIdException.class)
	public ResponseEntity<String> handleInvalidVendorIdException(InvalidVendorIdException e) {
		return new ResponseEntity<String>(e.getMessage(),HttpStatus.LENGTH_REQUIRED);
	}
	
	/**
	 * Invalid_Product_Id exception handler method
	 * 
	 * @param e
	 * @return exception message and status code
	 */
	@ExceptionHandler(InvalidProdIdException.class)
	public ResponseEntity<String> handleInvalidProdIdException(InvalidProdIdException e){
		return new ResponseEntity<String>(e.getMessage(),HttpStatus.LENGTH_REQUIRED);
	}
	
	/**
	 * Wrong_Vendor_Type exception handler method
	 * 
	 * @param e
	 * @return exception message and status code
	 */
	@ExceptionHandler(WrongVendorTypeException.class)
	public ResponseEntity<String> handleWrongVendorTypeException(WrongVendorTypeException e){
		return new ResponseEntity<String>(e.getMessage(),HttpStatus.NOT_FOUND);
	}
	
	/**
	 * Vendor_List_Empty exception handler method
	 * 
	 * @param e
	 * @return exception message and status code
	 */
	@ExceptionHandler(VendorListEmptyException.class)
	public ResponseEntity<String> handleVendorListEmptyException(VendorListEmptyException e){
		return new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
	}
}
