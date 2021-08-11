package com.capg.inventorymgmtsystem.web;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.inventorymgmtsystem.dto.VendorDto;
import com.capg.inventorymgmtsystem.exceptions.InvalidProdIdException;
import com.capg.inventorymgmtsystem.exceptions.ProductListEmptyException;
import com.capg.inventorymgmtsystem.exceptions.VendorAlreadyPresentException;
import com.capg.inventorymgmtsystem.exceptions.VendorListEmptyException;
import com.capg.inventorymgmtsystem.exceptions.WrongVendorTypeException;
import com.capg.inventorymgmtsystem.service.VendorService;
import com.capg.inventorymgmtsystem.util.*;
import com.capg.inventorymgmtsystem.entity.InventoryTxn;
import com.capg.inventorymgmtsystem.entity.Vendor;


/**
 * 
 * @author Sakshi
 *  VENDOR Controller
 *
 */
@CrossOrigin(VendorConstants.ORIGIN)
@RestController
@RequestMapping(VendorConstants.LOGIN_URL)
public class VendorController {
	
	
	@Autowired
	VendorService vendorService;
	
	/**
	 * Add Vendor method
	 * 
	 * @param vendor
	 * @return String
	 */
	
	@PostMapping(VendorConstants.ADD_VENDOR_URL)
	public ResponseEntity<?> addVendor(@RequestBody VendorDto vendorDto) throws VendorAlreadyPresentException, WrongVendorTypeException{
		
		return new ResponseEntity<>(vendorService.addVendor(vendorDto), HttpStatus.OK);
	}
	

	/**
	 * View All Vendors in Inventory method
	 * 
	 * @return List of Vendors in inventory
	 */
	@GetMapping(VendorConstants.VIEW_ALL_VENDORS_URL)
	public ResponseEntity<?> viewAllVendors() throws VendorListEmptyException {
		return new ResponseEntity<List<Vendor>>(vendorService.viewAllVendors(), HttpStatus.OK);
	}
	

	/**
	 * View All Transactions of specific productId in Inventory method
	 * 
	 * @return List of Transactions of specific productId in inventory
	 */
	@GetMapping(VendorConstants.TXN_OF_SPEC_PRODUCT_URL)
		public ResponseEntity<?> viewTxnOfSpecProduct(@PathVariable("productId") long productId) throws InvalidProdIdException, ProductListEmptyException{
				return new ResponseEntity<List<InventoryTxn>>(vendorService.txnOfSpecProduct(productId),HttpStatus.OK);
			
		}

	
	

}
