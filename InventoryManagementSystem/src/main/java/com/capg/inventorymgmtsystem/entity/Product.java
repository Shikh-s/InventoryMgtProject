package com.capg.inventorymgmtsystem.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * @author Piyush PRODUCT POJO Class
 *
 */
@Entity
@Table(name = "Product")
public class Product {

	@Id
	@Column(name = "product_id")
	private long productId;
	@Column(name = "product_name", length = 25)
	private String productName;
	@Column(name = "product_model", length = 25)
	private String productModel;
	@Column(name = "product_brand", length = 25)
	private String brand;
	@Column(name = "product_stock")
	private int stock;
	@Column(name = "seller_price")
	private double sellerPrice;
	@Column(name = "supplier_price")
	private double supplierPrice;

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductModel() {
		return productModel;
	}

	public void setProductModel(String productModel) {
		this.productModel = productModel;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public double getSellerPrice() {
		return sellerPrice;
	}

	public void setSellerPrice(double sellerPrice) {
		this.sellerPrice = sellerPrice;
	}

	public double getSupplierPrice() {
		return supplierPrice;
	}

	public void setSupplierPrice(double supplierPrice) {
		this.supplierPrice = supplierPrice;
	}

	/**
	 * Default constructor
	 */
	public Product() {
		super();
	}

	/**
	 * Parameterized constructor
	 * 
	 * @param productId
	 * @param productName
	 * @param productModel
	 * @param brand
	 * @param stock
	 * @param sellerPrice
	 * @param supplierPrice
	 */
	public Product(long productId, String productName, String productModel, String brand, int stock, double sellerPrice,
			double supplierPrice) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productModel = productModel;
		this.brand = brand;
		this.stock = stock;
		this.sellerPrice = sellerPrice;
		this.supplierPrice = supplierPrice;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", productModel=" + productModel
				+ ", brand=" + brand + ", stock=" + stock + ", sellerPrice=" + sellerPrice + ", supplierPrice="
				+ supplierPrice + "]";
	}

}
