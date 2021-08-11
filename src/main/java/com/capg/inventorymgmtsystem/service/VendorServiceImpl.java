package com.capg.inventorymgmtsystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.inventorymgmtsystem.dao.InventoryTxnDao;
import com.capg.inventorymgmtsystem.dao.ProductDao;
import com.capg.inventorymgmtsystem.dao.VendorDao;
import com.capg.inventorymgmtsystem.dto.VendorDto;
import com.capg.inventorymgmtsystem.entity.InventoryTxn;
import com.capg.inventorymgmtsystem.entity.Product;
import com.capg.inventorymgmtsystem.entity.Vendor;
import com.capg.inventorymgmtsystem.exceptions.InvalidProdIdException;
import com.capg.inventorymgmtsystem.exceptions.ProductListEmptyException;
import com.capg.inventorymgmtsystem.exceptions.VendorAlreadyPresentException;
import com.capg.inventorymgmtsystem.exceptions.VendorListEmptyException;
import com.capg.inventorymgmtsystem.exceptions.WrongVendorTypeException;
import com.capg.inventorymgmtsystem.util.VendorConstants;

/**
 * 
 * @author Sakshi VENDOR SERVICE Implementation
 */
@Service
public class VendorServiceImpl implements VendorService {

	@Autowired
	private VendorDao vendorDao;
	
	@Autowired
	private InventoryTxnDao inventoryDao;
	
	@Autowired 
	private ProductDao productDao;
	

	/**
	 * abstract method add_Vendor into Inventory
	 * 
	 * @param vendor
	 * @return Vendor
	 */

	@Override
	public Vendor addVendor(VendorDto vendorDto) {
		Optional<Vendor> vid = vendorDao.findById(vendorDto.getVendorId());
		Vendor vendor=new Vendor();
		vendor.setVendorId(vendorDto.getVendorId());
		vendor.setAddress(vendorDto.getAddress());
		vendor.setVendortype(vendorDto.getVendortype());
		vendor.setCompanyName(vendorDto.getCompanyName());
		vendor.setContact(vendorDto.getContact());
		vendor.setArea(vendorDto.getArea());
		vendor.setCity(vendorDto.getCity());
		if (vid.isPresent()) {
			throw new VendorAlreadyPresentException(VendorConstants.ALREADYPRESENT);
		} 
		else {
			if(!(vendor.getVendortype().equals(VendorConstants.SUPPLIER) || vendor.getVendortype().equals(VendorConstants.CONSUMER))) 
				throw new WrongVendorTypeException(VendorConstants.UNKNOWN_VENDOR_TYPE);

				else
			vendorDao.save(vendor);

		}
		return vendor;
	}

	/**
	 * abstract method view_All_Vendors of Inventory
	 * 
	 * @return list of vendors in inventory
	 */
	@Override
	public List<Vendor> viewAllVendors() {
		List<Vendor> vendorList = vendorDao.findAll();
		if (!vendorList.isEmpty()) {
			return vendorList;
		} else
			throw new VendorListEmptyException(VendorConstants.EMPTY);

	}

	/**
	 * abstract method txn_Of_Spec_product of Inventory
	 * 
	 * @return list of Transactions for that productId in Inventory
	 */
	@Override
	public List<InventoryTxn> txnOfSpecProduct(long productId) {
		List<InventoryTxn> txnlist=inventoryDao.viewInventoryProd(productId);
		Optional<Product> pid= productDao.findById(productId);
		if(!pid.isPresent())
			throw new InvalidProdIdException(VendorConstants.INVALID_PRODUCTID);
		else if(pid.isPresent() && txnlist.isEmpty())
			throw new ProductListEmptyException(VendorConstants.NO_TRANSACTIONS);
		
		return txnlist;
	}
	}


