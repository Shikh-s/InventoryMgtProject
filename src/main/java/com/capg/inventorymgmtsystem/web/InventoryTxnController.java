package com.capg.inventorymgmtsystem.web;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

import com.capg.inventorymgmtsystem.dto.InventoryTxnDto;
import com.capg.inventorymgmtsystem.entity.InventoryTxn;
import com.capg.inventorymgmtsystem.exceptions.InvalidProdIdException;
import com.capg.inventorymgmtsystem.exceptions.InvalidVendorIdException;
import com.capg.inventorymgmtsystem.exceptions.OutOfStockException;
import com.capg.inventorymgmtsystem.exceptions.VendorListEmptyException;
import com.capg.inventorymgmtsystem.exceptions.WrongVendorTypeException;
import com.capg.inventorymgmtsystem.service.InventoryTxnService;
import com.capg.inventorymgmtsystem.util.InventoryTxnConstants;

/**
 * 
 * @author Shikhar
 * Inventory Transaction Controller
 *
 *
 */
@CrossOrigin(origins= InventoryTxnConstants.CROSS_ORIGIN_URL)
@RestController
@RequestMapping(InventoryTxnConstants.ADMIN_URL)
public class InventoryTxnController {
	
	private static final Logger logger = LoggerFactory.getLogger(ProductController.class);
	
	@Autowired
	public InventoryTxnService inventoryTxnService;
	
	/**
	 * Add Inventory Transaction method
	 * 
	 * @param inventoryTxnDto - Dto of inventory transaction
	 * @return InventoryTxn - Entity of inventory transaction
	 */
	@PostMapping(InventoryTxnConstants.ADD_INVENTORY_TXN_URL)
	public ResponseEntity<?> addInventoryTxn(@RequestBody InventoryTxnDto inventoryTxnDto) throws OutOfStockException,InvalidVendorIdException,InvalidProdIdException,WrongVendorTypeException {
		logger.info(InventoryTxnConstants.ADD_INVENTORY_TXN_ACCESSED);	
		return new ResponseEntity<>(inventoryTxnService.addInvTxn(inventoryTxnDto),HttpStatus.OK);
	}
	
	/**
	 * View List of all Inventory transactions of specific vendor
	 * 
	 * @param vendorId
	 * @return List of Inventory transactions of specific vendor
	 */
	@GetMapping(InventoryTxnConstants.TXN_OF_SPEC_VENDOR_URL)
	public ResponseEntity<?> viewTxnOfSpecVendor(@PathVariable("vendorId") long vendorId) throws InvalidVendorIdException,VendorListEmptyException{
		logger.info(InventoryTxnConstants.TXN_OF_SPEC_VENDOR_ACCESSED);		
		return new ResponseEntity<List<InventoryTxn>>(inventoryTxnService.txnOfSpecVendor(vendorId),HttpStatus.OK);		
	}
	
}
