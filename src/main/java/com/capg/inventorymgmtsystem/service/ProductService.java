package com.capg.inventorymgmtsystem.service;

import java.util.List;

import com.capg.inventorymgmtsystem.dto.ProductDto;
import com.capg.inventorymgmtsystem.entity.Product;

/**
 * 
 * @author Piyush 
 * PRODUCT SERVICE INTERFACE
 */
public interface ProductService {

	/**
	 * abstract method: addProduct
	 * 
	 * @param product - Dto Object of Product
	 * @return String - product added successfully
	 */
	public String addProduct(ProductDto productDto);

	/**
	 * abstract method: updateProduct 
	 * Description: To add a new product in the inventory list
	 * @param product - Dto object of Product
	 * @return String - product updated successfully
	 */
	public String updateProduct(ProductDto productDto);

	/**
	 * abstract method: deleteProduct 
	 * Description:To update the details of existing product
	 * @param productId - product Id of existing Product
	 * @return String   - product deleted successfully
	 */
	public String deleteProduct(long productId);

	/**
	 * abstract method: viewAllProducts 
	 * Description:To delete an existing product from the inventory list
	 * @return list of products in inventory
	 */
	public List<Product> viewAllProducts();

}
