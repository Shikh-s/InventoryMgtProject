package com.capg.inventorymgmtsystem.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.capg.inventorymgmtsystem.dao.InventoryTxnDao;
import com.capg.inventorymgmtsystem.dao.ProductDao;
import com.capg.inventorymgmtsystem.dao.VendorDao;
import com.capg.inventorymgmtsystem.dto.InventoryTxnDto;
import com.capg.inventorymgmtsystem.entity.InventoryTxn;
import com.capg.inventorymgmtsystem.entity.Product;
import com.capg.inventorymgmtsystem.entity.Vendor;
import com.capg.inventorymgmtsystem.exceptions.InvalidProdIdException;
import com.capg.inventorymgmtsystem.exceptions.InvalidVendorIdException;
import com.capg.inventorymgmtsystem.exceptions.OutOfStockException;
import com.capg.inventorymgmtsystem.exceptions.VendorListEmptyException;
import com.capg.inventorymgmtsystem.exceptions.WrongVendorTypeException;
import com.capg.inventorymgmtsystem.util.InventoryTxnConstants;

/**
 * 
 * @author Shikhar
 * 
 * Description- It is a service class that provides the services for
 * adding the inventory transaction, viewing the list of transaction
 * of specific vendor by vendor Id
 * 
 */
@Service
public class InventoryTxnServiceImpl implements InventoryTxnService {

	@Autowired
	private InventoryTxnDao dao;

	@Autowired
	private ProductDao pDao;

	@Autowired
	private VendorDao vDao;
	
	/**
	 * Method:addInvTxn
	 * Description:To add a new inventory transaction
	 * @param dto - Dto object of Inventory Transaction
	 * @return InventoryTxn  
	 */
	@Override
	public InventoryTxn addInvTxn(InventoryTxnDto dto) {

		InventoryTxn txn = new InventoryTxn();
		Product prod = dao.viewProduct(dto.getProductId());
		Vendor vendor = dao.viewVendor(dto.getVendorId());
		
		txn.setProd(prod);
		txn.setVendor(vendor);
		txn.setTxtType(dto.getVendortype());
		txn.setDateOfTxn(LocalDate.now());
		txn.setQty(dto.getQty());

		if (prod == null)
			throw new InvalidProdIdException(InventoryTxnConstants.INVALID_PRODUCT);

		else if (vendor == null)
			throw new InvalidVendorIdException(InventoryTxnConstants.INVALID_VENDOR);

		else if (!(txn.getTxtType().equals(InventoryTxnConstants.SUPPLIER)|| txn.getTxtType().equals(InventoryTxnConstants.CONSUMER)))
			throw new WrongVendorTypeException(InventoryTxnConstants.UNKNOWN_VENDOR_TYPE);

		else if (txn.getTxtType().equals(InventoryTxnConstants.CONSUMER) && txn.getQty() > prod.getStock())
			throw new OutOfStockException(InventoryTxnConstants.OUT_OF_STOCK);

		else {
			if (txn.getTxtType().equals(InventoryTxnConstants.SUPPLIER)	&& vendor.getVendortype().equals(txn.getTxtType()))
				prod.setStock(prod.getStock() + dto.getQty());

			else if (txn.getTxtType().equals(InventoryTxnConstants.CONSUMER) && vendor.getVendortype().equals(txn.getTxtType()))
				prod.setStock(prod.getStock() - dto.getQty());

			else
				throw new WrongVendorTypeException(InventoryTxnConstants.UNKNOWN_VENDOR_TYPE);

			pDao.save(prod);
			dao.save(txn);
		}
		return txn;
	}

	/**
	 * abstract method txnOfSpecVendor of Inventory
	 * @param vendorId
	 * @return list of Inventory transactions of specific vendor 
	 */
	@Override
	public List<InventoryTxn> txnOfSpecVendor(long vendorId) {

		List<InventoryTxn> txnlst = dao.viewInventory(vendorId);
		Optional<Vendor> vid = vDao.findById(vendorId);

		if (!vid.isPresent())
			throw new InvalidVendorIdException(InventoryTxnConstants.INVALID_VENDOR);

		else if (vid.isPresent() && txnlst.isEmpty())
			throw new VendorListEmptyException(InventoryTxnConstants.NO_TRANSACTIONS);

		return txnlst;
	}
}
