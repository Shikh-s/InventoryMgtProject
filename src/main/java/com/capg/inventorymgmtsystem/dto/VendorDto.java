package com.capg.inventorymgmtsystem.dto;

/**
 * 
 * @author Sakshi VendorDto(Data Transfer Object) class
 *
 */
public class VendorDto {
	
	private long vendorId;
	private String companyName;
	private String address;
	private String contact;
	private String vendortype;
	private String area;
	private String city;
	

	/**
	 * default constructor
	 */
public VendorDto() {
	
}

public long getVendorId() {
	return vendorId;
}

public void setVendorId(long vendorId) {
	this.vendorId = vendorId;
}

public String getCompanyName() {
	return companyName;
}

public void setCompanyName(String companyName) {
	this.companyName = companyName;
}

public String getAddress() {
	return address;
}

public void setAddress(String address) {
	this.address = address;
}

public String getContact() {
	return contact;
}

public void setContact(String contact) {
	this.contact = contact;
}

public String getVendortype() {
	return vendortype;
}

public void setVendortype(String vendortype) {
	this.vendortype = vendortype;
}


public String getArea() {
	return area;
}

public void setArea(String area) {
	this.area = area;
}

public String getCity() {
	return city;
}

public void setCity(String city) {
	this.city = city;
}

/**
 * Parameterized constructor
 * 
 * @param vendorId
 * @param companyName
 * @param address
 * @param contact
 * @param vendorType
 */

public VendorDto(long vendorId, String companyName, String address, String contact, String vendortype, String area, String city) {
	super();
	this.vendorId = vendorId;
	this.companyName = companyName;
	this.address = address;
	this.contact = contact;
	this.vendortype = vendortype;
	this.area= area;
	this.city=city;
}


}
