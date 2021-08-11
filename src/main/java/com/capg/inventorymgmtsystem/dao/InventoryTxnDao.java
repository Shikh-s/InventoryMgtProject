package com.capg.inventorymgmtsystem.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.capg.inventorymgmtsystem.entity.InventoryTxn;
import com.capg.inventorymgmtsystem.entity.Product;
import com.capg.inventorymgmtsystem.entity.Vendor;

/**
 * 
 * @author Shikhar
 *
 *         Inventory Transaction DAO Repository
 */
@Repository
public interface InventoryTxnDao extends JpaRepository<InventoryTxn, Long>{

	@Query("SELECT p from Product p WHERE p.productId=:pid")
	Product viewProduct(@Param("pid") long productId);

	@Query("SELECT v from Vendor v WHERE v.vendorId=:vid")
	Vendor viewVendor(@Param("vid") long vendorId);

	@Query("FROM InventoryTxn it where it.vendor.vendorId=:vid")
	List<InventoryTxn> viewInventory(@Param("vid") long vendorId);
	
	@Query("FROM InventoryTxn it where it.prod.productId=:pid")
	List<InventoryTxn> viewInventoryProd(@Param("pid") long productId);
	
}