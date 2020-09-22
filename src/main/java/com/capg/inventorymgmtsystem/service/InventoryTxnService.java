package com.capg.inventorymgmtsystem.service;

import java.util.List;

import com.capg.inventorymgmtsystem.dto.InventoryTxnDto;
import com.capg.inventorymgmtsystem.entity.InventoryTxn;

public interface InventoryTxnService {
	public InventoryTxn addInvTxn(InventoryTxnDto dto);

	public List<InventoryTxn> txnOfSpecVendor(long vendorId); 
}
