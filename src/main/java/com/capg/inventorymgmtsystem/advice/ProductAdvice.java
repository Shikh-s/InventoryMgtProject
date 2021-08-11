package com.capg.inventorymgmtsystem.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.capg.inventorymgmtsystem.exceptions.InvalidProdIdException;
import com.capg.inventorymgmtsystem.exceptions.ProductListEmptyException;
import com.capg.inventorymgmtsystem.exceptions.ProductNotAddedException;
import com.capg.inventorymgmtsystem.exceptions.ProductNotFoundException;

/**
 * Product Advice Class 
 * Exceptions are handled
 * 
 * @author Piyush
 *
 */
@RestControllerAdvice
public class ProductAdvice {

	/**
	 * Product_Not_Added exception handler method
	 * 
	 * @param e
	 * @return exception message and status code
	 */
	@ExceptionHandler(ProductNotAddedException.class)
	public ResponseEntity<String> handleProductNotAddedException(ProductNotAddedException e) {
		return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
	}

	/**
	 * Invalid_Product_Id exception handler method
	 * 
	 * @param e
	 * @return exception message and status code
	 */
	@ExceptionHandler(InvalidProdIdException.class)
	public ResponseEntity<String> handleInvalidProductIdException(InvalidProdIdException e) {
		return new ResponseEntity<String>(e.getMessage(), HttpStatus.LENGTH_REQUIRED);
	}

	/**
	 * Product_Not_Found exception handler method
	 * 
	 * @param e
	 * @return exception message and status code
	 */
	@ExceptionHandler(ProductNotFoundException.class)
	public ResponseEntity<String> handleProductNotFoundException(ProductNotFoundException e) {
		return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
	}

	/**
	 * Product_List_Empty exception handler method
	 * 
	 * @param e
	 * @return exception message and status code
	 */
	@ExceptionHandler(ProductListEmptyException.class)
	public ResponseEntity<String> handleProductListEmptyException(ProductListEmptyException e) {
		return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
	}

}
