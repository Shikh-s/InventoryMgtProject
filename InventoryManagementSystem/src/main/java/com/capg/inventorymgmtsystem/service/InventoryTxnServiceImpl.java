package com.capg.inventorymgmtsystem.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.inventorymgmtsystem.dao.InventoryTxnDao;
import com.capg.inventorymgmtsystem.dao.ProductDao;
import com.capg.inventorymgmtsystem.dto.InventoryTxnDto;
import com.capg.inventorymgmtsystem.entity.InventoryTxn;
import com.capg.inventorymgmtsystem.entity.Product;
import com.capg.inventorymgmtsystem.entity.Vendor;
import com.capg.inventorymgmtsystem.exceptions.InvalidProdIdException;
import com.capg.inventorymgmtsystem.exceptions.InvalidVendorIdException;
import com.capg.inventorymgmtsystem.exceptions.OutOfStockException;
import com.capg.inventorymgmtsystem.util.InventoryTxnConstants;

@Service
public class InventoryTxnServiceImpl implements InventoryTxnService{
	
	@Autowired
	private InventoryTxnDao dao;
	@Autowired
	private ProductDao pDao;
	
	@Override
	public InventoryTxn addInvTxn(InventoryTxnDto dto) {
		InventoryTxn txn = new InventoryTxn();
		Product prod = dao.viewProduct(dto.getProductId());
		if (prod == null) throw new InvalidProdIdException(InventoryTxnConstants.INVALID_PRODUCT);
		Vendor vendor = dao.viewVendor(dto.getVendorId());
		if(vendor == null) throw new InvalidVendorIdException(InventoryTxnConstants.INVALID_VENDOR);
				
		if(dto.getVendortype().equals(InventoryTxnConstants.CUSTOMER) && txn.getQty()>prod.getStock())		
			throw new OutOfStockException(InventoryTxnConstants.OUT_OF_STOCK);
		
					
			long txnId = dao.getMaxTxID();
			txn.setInventoryId(txnId);
			txn.setProd(prod);
			txn.setVendor(vendor);
			txn.setTxtType(dto.getVendortype());
			txn.setDateOfTxn(LocalDate.now());
			txn.setQty(dto.getQty());
			if(txn.getVendor().getVendortype().equals(InventoryTxnConstants.SUPPLIER)) 
				prod.setStock(prod.getStock() + dto.getQty());
				
			else
				prod.setStock(prod.getStock() - dto.getQty());
			
			
			pDao.save(prod);
			dao.save(txn);
		return txn;
		
		
	}
	@Override
	public List<InventoryTxn> txnOfSpecVendor(long vendorId) {
		List<InventoryTxn> txnlst=dao.viewInventory(vendorId);
		System.out.println(txnlst);
		if(txnlst.isEmpty())
			throw new InvalidVendorIdException(InventoryTxnConstants.NO_TRANSACTIONS);
		return txnlst;
	}
	
}
