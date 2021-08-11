package com.capg.inventorymgmtsystem.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.capg.inventorymgmtsystem.entity.InventoryTxn;
import com.capg.inventorymgmtsystem.entity.Vendor;


/**
 * 
 * @author  Sakshi
 *
 *         VENDOR DAO Repository
 */
@Repository
public interface VendorDao extends JpaRepository<Vendor, Long> {
	
	
	 
	@Query("Select v from Vendor v where v.vendorId=:vid")
	 Vendor viewVendor(@Param("vid")long vendorId);
	
	@Query("from InventoryTxn it where it.prod.productId=:pid and it.vendor.vendortype=:vtype")
	List<InventoryTxn> viewInventoryForProductId(@Param("pid")long productId, @Param("vtype")String vendorType);
	
	@Query("FROM InventoryTxn it where it.prod.productId=:pid")
	List<InventoryTxn> viewInventoryProd(@Param("pid") long productId);

}
