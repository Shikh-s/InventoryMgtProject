package com.capg.inventorymgmtsystem.util;

/**
 * Product_Constants Class
 * @author Piyush
 * 
 *
 */
public class ProductConstants {

	public static final String PRODUCT_ADDED = "! Product added !";
	public static final String PRODUCT_NOT_ADDED = "! Product ID already exists !";
	public static final String PRODUCT_NOT_FOUND = "! Product ID doesn't exist !";
	public static final String PRODUCT_DELETED = "! Product deleted successfully !";
	public static final String PRODUCT_UPDATED = "! Product details updated successfully !";
	public static final String EMPTY_INVENTORY = "! Inventory is Empty !";
	public static final String INVALID_PRODUCT_ID = "! Product ID must be of minimum 4 digits !";
	public static final String LOGIN_URL = "/login";
	public static final String ADD_PRODUCT_URL = "/addProduct";
	public static final String UPDATE_PRODUCT_URL = "/updateProduct";
	public static final String VIEW_ALL_PRODUCTS_URL = "/viewAllProducts";
	public static final String DELETE_PRODUCT_URL = "/deleteProduct/{productId}";
	public static final String PRODUCT_ID = "productId";
}
