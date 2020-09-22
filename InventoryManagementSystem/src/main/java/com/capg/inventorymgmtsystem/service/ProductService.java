package com.capg.inventorymgmtsystem.service;

import java.util.List;

import com.capg.inventorymgmtsystem.dto.ProductDto;
import com.capg.inventorymgmtsystem.entity.Product;

/**
 * 
 * @author Piyush PRODUCT SERVICE INTERFACE
 */
public interface ProductService {

	/**
	 * abstract method add_Product into Inventory
	 * 
	 * @param product
	 * @return String
	 */
	public String addProduct(ProductDto productDto);

	/**
	 * abstract method update_Product details
	 * 
	 * @param product
	 * @return String
	 */
	public String updateProduct(ProductDto productDto);

	/**
	 * abstract method delete_Product from inventory
	 * 
	 * @param productId
	 * @return String
	 */
	public String deleteProduct(long productId);

	/**
	 * abstract method view_All_Products of Inventory
	 * 
	 * @return list of products in inventory
	 */
	public List<Product> viewAllProducts();

}
