package com.capg.inventorymgmtsystem.dto;


public class InventoryTxnDto {
	private int qty;
	private long vendorId;
	private long productId;
	private String vendortype;
	public InventoryTxnDto(){
		
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public long getVendorId() {
		return vendorId;
	}
	public void setVendorId(long vendorId) {
		this.vendorId = vendorId;
	}
	public long getProductId() {
		return productId;
	}
	public void setProductId(long productId) {
		this.productId = productId;
	}
	public String getVendortype() {
		return vendortype;
	}
	public void setVendortype(String vendortype) {
		this.vendortype = vendortype;
	}
	public InventoryTxnDto(int qty, long vendorId, long productId, String vendortype) {
		super();
		this.qty = qty;
		this.vendorId = vendorId;
		this.productId = productId;
		this.vendortype = vendortype;
	}
	
	
}
