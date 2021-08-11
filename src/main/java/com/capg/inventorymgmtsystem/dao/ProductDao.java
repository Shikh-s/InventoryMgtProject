package com.capg.inventorymgmtsystem.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capg.inventorymgmtsystem.entity.Product;

/**
 * 
 * @author Piyush
 *
 *         PRODUCT DAO Repository
 */
@Repository
public interface ProductDao extends JpaRepository<Product, Long>  {
	



}
