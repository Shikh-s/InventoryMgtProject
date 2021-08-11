package com.capg.inventorymgmtsystem.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.capg.inventorymgmtsystem.exceptions.InvalidProdIdException;
import com.capg.inventorymgmtsystem.exceptions.ProductListEmptyException;
import com.capg.inventorymgmtsystem.exceptions.VendorAlreadyPresentException;
import com.capg.inventorymgmtsystem.exceptions.VendorListEmptyException;
import com.capg.inventorymgmtsystem.exceptions.WrongVendorTypeException;



/**
 * Vendor Advice Class 
 * Exceptions are handled
 * 
 * @author Sakshi
 *
 */
@RestControllerAdvice
public class  VendorAdvice {
	
	/**
	 * Vendor_Already_Present exception handler method
	 * 
	 * @param e
	 * @return exception message and status code
	 */

		@ExceptionHandler(VendorAlreadyPresentException.class)
		public ResponseEntity<String> handleVendorAlreadyPresentException(VendorAlreadyPresentException e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}

		/**
		 * Invalid_ProdId exception handler method
		 * 
		 * @param e
		 * @return exception message and status code
		 */
		@ExceptionHandler(InvalidProdIdException.class)
		public ResponseEntity<String> handleInvalidProductIdException(InvalidProdIdException e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.LENGTH_REQUIRED);
		}


		/**
		 * Vendor_List_Empty exception handler method
		 * 
		 * @param e
		 * @return exception message and status code
		 */
		
		@ExceptionHandler(VendorListEmptyException.class)
		public ResponseEntity<String> handleVendorListEmptyException(VendorListEmptyException e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		/**
		 * Wrong_Vendor_Type exception handler method
		 * 
		 * @param e
		 * @return exception message and status code
		 */

		@ExceptionHandler(WrongVendorTypeException.class)
		public ResponseEntity<String> handleWrongVendorTypeException(WrongVendorTypeException e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
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

