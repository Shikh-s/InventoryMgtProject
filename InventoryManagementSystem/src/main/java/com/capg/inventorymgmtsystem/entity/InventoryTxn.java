package com.capg.inventorymgmtsystem.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="InventoryTxn")
public class InventoryTxn {

	@Id
	@Column(name="inventory_id")
	private long inventoryId;
	@Column(name="qty")
	private int qty;
	@Column(name="date_of_txn")
	private LocalDate dateOfTxn;
	@Column(name="txt_type", length=25)
	private String txtType;
	@ManyToOne
	@JoinColumn(name="product_id", referencedColumnName = "product_id")
	private Product prod = new Product();
	
	@ManyToOne
	@JoinColumn(name="vendor_id", referencedColumnName = "vendor_id")
	private Vendor vendor = new Vendor();

	public long getInventoryId() {
		return inventoryId;
	}

	public void setInventoryId(long inventoryId) {
		this.inventoryId = inventoryId;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public LocalDate getDateOfTxn() {
		return dateOfTxn;
	}

	public void setDateOfTxn(LocalDate dateOfTxn) {
		this.dateOfTxn = dateOfTxn;
	}

	public String getTxtType() {
		return txtType;
	}

	public void setTxtType(String txtType) {
		this.txtType = txtType;
	}

	public Product getProd() {
		return prod;
	}

	public void setProd(Product prod) {
		this.prod = prod;
	}

	public Vendor getVendor() {
		return vendor;
	}

	public void setVendor(Vendor vendor) {
		this.vendor = vendor;
	}

	public InventoryTxn() {
		super();
	}

	public InventoryTxn(long inventoryId, int qty, LocalDate dateOfTxn, String txtType, Product prod, Vendor vendor) {
		super();
		this.inventoryId = inventoryId;
		this.qty = qty;
		this.dateOfTxn = dateOfTxn;
		this.txtType = txtType;
		this.prod = prod;
		this.vendor = vendor;
	}

	@Override
	public String toString() {
		return "InventoryTxn [inventoryId=" + inventoryId + ", qty=" + qty + ", dateOfTxn=" + dateOfTxn + ", txtType="
				+ txtType + ", prod=" + prod + ", vendor=" + vendor + "]";
	}


	
}
