package com.capg.inventorymgmtsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.inventorymgmtsystem.dto.ProductDto;
import com.capg.inventorymgmtsystem.entity.Product;
import com.capg.inventorymgmtsystem.excpetions.InvalidProductIdException;
import com.capg.inventorymgmtsystem.excpetions.ProductListEmptyException;
import com.capg.inventorymgmtsystem.excpetions.ProductNotAddedException;
import com.capg.inventorymgmtsystem.excpetions.ProductNotFoundException;
import com.capg.inventorymgmtsystem.service.ProductService;
import com.capg.inventorymgmtsystem.util.ProductConstants;

/**
 * 
 * @author Piyush PRODUCT Controller
 *
 */
@RestController
@RequestMapping(ProductConstants.LOGIN_URL)
public class ProductController {

	@Autowired
	ProductService productService;

	/**
	 * Add Product method
	 * 
	 * @param product
	 * @return String
	 */
	@PostMapping(ProductConstants.ADD_PRODUCT_URL)
	public ResponseEntity<String> addProduct(@RequestBody ProductDto product)
			throws ProductNotAddedException, InvalidProductIdException {
		return new ResponseEntity<String>(productService.addProduct(product), HttpStatus.OK);
	}

	/**
	 * Update Product method
	 * 
	 * @param product
	 * @return String
	 */
	@PutMapping(ProductConstants.UPDATE_PRODUCT_URL)
	public ResponseEntity<String> updateProduct(@RequestBody ProductDto productDto) throws ProductNotFoundException {
		return new ResponseEntity<String>(productService.updateProduct(productDto), HttpStatus.OK);
	}

	/**
	 * View All Products in Inventory method
	 * 
	 * @return List of Products in inventory
	 */
	@GetMapping(ProductConstants.VIEW_ALL_PRODUCTS_URL)
	public ResponseEntity<?> viewAllProducts() throws ProductListEmptyException {
		return new ResponseEntity<List<Product>>(productService.viewAllProducts(), HttpStatus.OK);
	}

	/**
	 * Delete Product from Inventory method
	 * 
	 * @param productId
	 * @return String
	 */
	@DeleteMapping(ProductConstants.DELETE_PRODUCT_URL)
	public ResponseEntity<String> deleteUser(@PathVariable(value = ProductConstants.PRODUCT_ID) long productId)
			throws ProductNotFoundException, InvalidProductIdException {
		return new ResponseEntity<String>(productService.deleteProduct(productId), HttpStatus.OK);
	}
}
