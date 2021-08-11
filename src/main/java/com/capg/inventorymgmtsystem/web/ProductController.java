package com.capg.inventorymgmtsystem.web;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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
import com.capg.inventorymgmtsystem.exceptions.InvalidProdIdException;
import com.capg.inventorymgmtsystem.exceptions.ProductListEmptyException;
import com.capg.inventorymgmtsystem.exceptions.ProductNotAddedException;
import com.capg.inventorymgmtsystem.exceptions.ProductNotFoundException;
import com.capg.inventorymgmtsystem.service.ProductService;
import com.capg.inventorymgmtsystem.util.ProductConstants;

/**
 * 
 * @author Piyush 
 * Product Controller
 *
 *
 */
@CrossOrigin(origins= "http://localhost:4200")
@RestController
@RequestMapping(ProductConstants.LOGIN_URL)
public class ProductController {

	private static final Logger logger = LoggerFactory.getLogger(ProductController.class);
	
	@Autowired
	ProductService productService;

	/**
	 * Add Product method
	 * 
	 * @param product
	 * @return String
	 */
	@PostMapping(ProductConstants.ADD_PRODUCT_URL)
	public ResponseEntity<String> addProduct(@RequestBody ProductDto product) throws ProductNotAddedException, InvalidProdIdException {
		logger.info(ProductConstants.ADD_PRODUCT_ACCESSED);
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
		logger.info(ProductConstants.UPDATE_PRODUCT_ACCESSED);
		return new ResponseEntity<String>(productService.updateProduct(productDto), HttpStatus.OK);
	}

	/**
	 * View All Products in Inventory method
	 * 
	 * @return List of Products in inventory
	 */
	@GetMapping(ProductConstants.VIEW_ALL_PRODUCTS_URL)
	public ResponseEntity<?> viewAllProducts() throws ProductListEmptyException {
		logger.info(ProductConstants.VIEW_ALL_PRODUCTS_ACCESSED);
		return new ResponseEntity<List<Product>>(productService.viewAllProducts(), HttpStatus.OK);
	}

	/**
	 * Delete Product from Inventory method
	 * 
	 * @param productId
	 * @return String
	 */
	@DeleteMapping(ProductConstants.DELETE_PRODUCT_URL)
	public ResponseEntity<String> deleteProduct(@PathVariable(value = ProductConstants.PRODUCT_ID) long productId) throws ProductNotFoundException, InvalidProdIdException {
		logger.info(ProductConstants.DELETE_PRODUCT_BY_ID_ACCESSED);
		return new ResponseEntity<String>(productService.deleteProduct(productId), HttpStatus.OK);
	}
}
