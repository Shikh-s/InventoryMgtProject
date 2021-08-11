package com.capg.inventorymgmtsystem.service;

import java.util.List;

import com.capg.inventorymgmtsystem.dto.InventoryTxnDto;
import com.capg.inventorymgmtsystem.entity.InventoryTxn;

/**
 * 
 * @author Shikhar 
 * INVENTORY TRANSACTION SERVICE INTERFACE
 */
public interface InventoryTxnService {
	
	/**
	 * abstract method: addInvTxn
	 * 
	 * @param dto - Dto Object of Inventory transaction
	 * @return InventoryTxn 
	 */
	public InventoryTxn addInvTxn(InventoryTxnDto dto);

	/**
	 * abstract method:txnOfSpecVendor 
	 * Description:To view transaction list of specific vendor by vendor Id
	 * @param vendorId - Vendor Id of a vendor
	 * @return list of transaction of specific vendor
	 */
	public List<InventoryTxn> txnOfSpecVendor(long vendorId); 
	
}
