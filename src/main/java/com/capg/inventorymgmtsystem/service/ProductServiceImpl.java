package com.capg.inventorymgmtsystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.inventorymgmtsystem.dao.ProductDao;
import com.capg.inventorymgmtsystem.dto.ProductDto;
import com.capg.inventorymgmtsystem.entity.Product;
import com.capg.inventorymgmtsystem.exceptions.InvalidProdIdException;
import com.capg.inventorymgmtsystem.exceptions.ProductListEmptyException;
import com.capg.inventorymgmtsystem.exceptions.ProductNotAddedException;
import com.capg.inventorymgmtsystem.exceptions.ProductNotFoundException;
import com.capg.inventorymgmtsystem.util.ProductConstants;

/**
 * 
 * @author Piyush
 * 
 *Description- It is a service class that provides the services for
 *viewing the list of existing products, adding a new product, updating
 *details of an existing product, deleting an existing product
 * 
 */
@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductDao productDao;

	/**
	 * Method:addProduct 
	 * Description: To add a new product in the inventory list
	 * @param productDto -Dto object of Product
	 * @return String    -Product added
	 * @throws ProductNotAddedException, InvalidProductIdException
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
		} 
		else {
			throw new InvalidProdIdException(ProductConstants.INVALID_PRODUCT_ID);
		}
	}

	/**
	 * Method:updateProduct 
	 * Description:To update the details of existing product
	 * @param product - Dto object of Product
	 * @return String - Product Updated successfully
	 * @throws ProductNotFoundException
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
	 * Method:deleteProduct 
	 * Description:To delete an existing product from the inventory list
	 * @param productId - Product Id of product
	 * @return String   - Product deleted successfully
	 * @throws ProductNotFoundException, InvalidProductIdException
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
			throw new InvalidProdIdException(ProductConstants.INVALID_PRODUCT_ID);
		}
	}

	/**
	 * Method:viewAllProducts 
	 * Description:To view the list of all existing products
	 * @return list of products in inventory
	 * @throws ProductListEmptyException
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
