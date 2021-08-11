package com.capg.inventorymgmtsystem.service;

import java.util.List;

import com.capg.inventorymgmtsystem.dto.VendorDto;
import com.capg.inventorymgmtsystem.entity.InventoryTxn;
import com.capg.inventorymgmtsystem.entity.Vendor;

/**
 * 
 * @author Sakshi VENDOR SERVICE INTERFACE
 */
public interface VendorService {
	
	/**
	 * abstract method add_Vendor into Inventory
	 * 
	 * @param vendor
	 * @return String
	 */
	public Vendor addVendor(VendorDto vendorDto);
	
	/**
	 * abstract method view_All_Vendors of Inventory
	 * 
	 * @return list of vendors in inventory
	 */
	public List<Vendor> viewAllVendors();
	
	/**
	 * abstract method txn_Of_Spec_product of Inventory
	 * 
	 * @return list of Transactions for that productId in Inventory
	 */
	public List<InventoryTxn> txnOfSpecProduct(long productId);
}
