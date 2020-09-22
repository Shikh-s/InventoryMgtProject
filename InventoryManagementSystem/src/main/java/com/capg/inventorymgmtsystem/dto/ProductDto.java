package com.capg.inventorymgmtsystem.dto;

/**
 * 
 * @author Piyush ProductDto(Data Transfer Object) class
 *
 */
public class ProductDto {

	private long productId;
	private String productName;
	private String productModel;
	private String brand;
	private int stock;
	private double sellerPrice;
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
	public ProductDto(long productId, String productName, String productModel, String brand, int stock,
			double sellerPrice, double supplierPrice) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productModel = productModel;
		this.brand = brand;
		this.stock = stock;
		this.sellerPrice = sellerPrice;
		this.supplierPrice = supplierPrice;
	}

	/**
	 * default constructor
	 */
	public ProductDto() {
		super();
	}

	@Override
	public String toString() {
		return "ProductDto [productId=" + productId + ", productName=" + productName + ", productModel=" + productModel
				+ ", brand=" + brand + ", stock=" + stock + ", sellerPrice=" + sellerPrice + ", supplierPrice="
				+ supplierPrice + "]";
	}

}
