package com.capg.inventorymgmtsystem.util;

/**
 * Inventory Transaction Constants Class
 * @author Shikhar
 * 
 *
 */
public class InventoryTxnConstants {
	
	public static final String SUPPLIER= "supplier";
	public static final String CONSUMER= "consumer";
	public static final String OUT_OF_STOCK= "The selected product is out of stock";
    public static final String INVALID_VENDOR= "Vendor ID does not exist."; 
    public static final String INVALID_PRODUCT= "There are no items to display in the stock";
    public static final String NO_TRANSACTIONS = "No transactions to display";
	public static final String UNKNOWN_VENDOR_TYPE = "Unknown Vendor Type";
	public static final String SUCCESS_TXN = "Transaction Done Successfully.";
	public static final String NO_PRODUCTS = "No Product Found";
	public static final String ADD_INVENTORY_TXN_URL="/addinventorytxn";
	public static final String TXN_OF_SPEC_VENDOR_URL="/txnOfSpecVendor/{vendorId}";
	public static final String ADMIN_URL="/admin";
	public static final String CROSS_ORIGIN_URL="http://localhost:4200";
	public static final String ADD_INVENTORY_TXN_ACCESSED = "add inventory txn accessed";
	public static final String TXN_OF_SPEC_VENDOR_ACCESSED = "txn of specific vendor accessed";
	
}
