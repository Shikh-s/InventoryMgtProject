package com.capg.inventorymgmtsystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.inventorymgmtsystem.dao.ProductDao;
import com.capg.inventorymgmtsystem.dto.ProductDto;
import com.capg.inventorymgmtsystem.entity.Product;
import com.capg.inventorymgmtsystem.excpetions.InvalidProductIdException;
import com.capg.inventorymgmtsystem.excpetions.ProductListEmptyException;
import com.capg.inventorymgmtsystem.excpetions.ProductNotAddedException;
import com.capg.inventorymgmtsystem.excpetions.ProductNotFoundException;
import com.capg.inventorymgmtsystem.util.ProductConstants;

/**
 * 
 * @author Piyush PRODUCT SERVICE Implementation
 */
@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductDao productDao;

	
	/**
	 * addProduct into Inventory implementation
	 * 
	 * @param product
	 * @return String
	 */
	@Override
	public String addProduct(ProductDto productDto) {
		Optional<Product> findbyId = productDao.findById(productDto.getProductId());
		if (productDto.getProductId() >= 1000) {
			if (!findbyId.isPresent()) {
				Product product = new Product();
				product.setProductId(productDto.getProductId());
				product.setBrand(productDto.getBrand());
				product.setProductModel(productDto.getProductModel());
				product.setProductName(productDto.getProductModel());
				product.setSellerPrice(productDto.getSellerPrice());
				product.setStock(productDto.getStock());
				product.setSupplierPrice(productDto.getSupplierPrice());
				productDao.save(product);
				return ProductConstants.PRODUCT_ADDED;
			} else {
				throw new ProductNotAddedException(ProductConstants.PRODUCT_NOT_ADDED);
			}
		} else {
			throw new InvalidProductIdException(ProductConstants.INVALID_PRODUCT_ID);
		}
	}

	
	/**
	 * updateProduct details in Inventory implementation
	 * 
	 * @param product
	 *            object
	 * @return String
	 */
	@Override
	public String updateProduct(ProductDto productDto) {
		Optional<Product> prd = productDao.findById(productDto.getProductId());
		if (prd.isPresent()) {
			Product updatedProduct = prd.get();
			updatedProduct.setBrand(productDto.getBrand());
			updatedProduct.setProductModel(productDto.getProductModel());
			updatedProduct.setProductName(productDto.getProductName());
			updatedProduct.setSellerPrice(productDto.getSellerPrice());
			updatedProduct.setStock(productDto.getStock());
			updatedProduct.setSupplierPrice(productDto.getSupplierPrice());
			productDao.save(updatedProduct);
			return ProductConstants.PRODUCT_UPDATED;
		} else {
			throw new ProductNotFoundException(ProductConstants.PRODUCT_NOT_FOUND);
		}
	}

	
	/**
	 * deleteProduct from Inventory implementation
	 * 
	 * @param productId
	 * @return String
	 */
	@Override
	public String deleteProduct(long productId) {
		Optional<Product> productById = productDao.findById(productId);
		if (productId >= 1000) {
			if (productById.isPresent()) {
				productDao.delete(productById.get());
				return ProductConstants.PRODUCT_DELETED;
			} else
				throw new ProductNotFoundException(ProductConstants.PRODUCT_NOT_FOUND);
		} else {
			throw new InvalidProductIdException(ProductConstants.INVALID_PRODUCT_ID);
		}
	}

	
	/**
	 * viewAllProducts of Inventory
	 * 
	 * @return list of products in inventory
	 */
	@Override
	public List<Product> viewAllProducts() {
		List<Product> productList = productDao.findAll();
		if (!productList.isEmpty()) {
			return productList;
		} else
			throw new ProductListEmptyException(ProductConstants.EMPTY_INVENTORY);
	}

}
