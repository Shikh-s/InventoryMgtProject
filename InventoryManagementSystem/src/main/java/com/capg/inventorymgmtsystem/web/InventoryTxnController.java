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

import com.capg.inventorymgmtsystem.dto.InventoryTxnDto;
import com.capg.inventorymgmtsystem.entity.InventoryTxn;
import com.capg.inventorymgmtsystem.exceptions.InvalidProdIdException;
import com.capg.inventorymgmtsystem.exceptions.InvalidVendorIdException;
import com.capg.inventorymgmtsystem.exceptions.OutOfStockException;
import com.capg.inventorymgmtsystem.service.InventoryTxnService;

@CrossOrigin(origins= "http://localhost:4200")
@RestController
@RequestMapping("/admin")
public class InventoryTxnController {
	@Autowired
	public InventoryTxnService inventoryTxnService;
	
	@PostMapping("/addinventorytxn")
	public ResponseEntity<?> addInventoryTxn(@RequestBody InventoryTxnDto inventoryTxnDto){
		try {
			return new ResponseEntity<>(inventoryTxnService.addInvTxn(inventoryTxnDto),HttpStatus.OK);
		}
		catch(OutOfStockException e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
		}
		catch(InvalidVendorIdException e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
		}
		catch(InvalidProdIdException e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/txnOfSpecVendor/{vendorId}")
	public ResponseEntity<?> viewTxnOfSpecVendor(@PathVariable("vendorId") long vendorId){
		try {
			return new ResponseEntity<List<InventoryTxn>>(inventoryTxnService.txnOfSpecVendor(vendorId),HttpStatus.OK);		
		}
		catch(InvalidVendorIdException e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
		}
		
	}
	
}
