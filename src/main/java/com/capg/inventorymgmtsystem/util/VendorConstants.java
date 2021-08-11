package com.capg.inventorymgmtsystem.util;

/**
 * Vendor_Constants Class
 * @author Sakshi
 * 
 *
 */
public class VendorConstants {

	public static final String SUPPLIER= "supplier";
	public static final String CONSUMER= "consumer";
	
	public static final String NOSUPPLIER = "No Supplier Found";
	public static final String NOCONSUMER = "No Consumer Found";
	
	public static final String ALREADYPRESENT = "Vendor Already Present";
	public static final String EMPTY = "Vendor List is Empty";
	

	public static final String VENDORADDED = "Vendor is Added Successfully";
	
	public static final String LOGIN_URL = "/login";
	public static final String ADD_VENDOR_URL = "/addVendor";
	

	public static final String VIEW_ALL_VENDORS_URL = "/viewAllVendors";
	public static final String ORIGIN= "http://localhost:4200";
	
	public static final String NO_TRANSACTIONS= "No transactions found for this product Id";
	public static final String TXN_OF_SPEC_PRODUCT_URL= "/txnOfSpecProduct/{productId}"; 
	
	public static final String UNKNOWN_VENDOR_TYPE= "Unknown Vendor Type";
	public static final String INVALID_PRODUCTID= "Invalid Product Id";
}
