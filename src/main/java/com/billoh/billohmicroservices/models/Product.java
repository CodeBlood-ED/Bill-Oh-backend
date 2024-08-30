package com.billoh.billohmicroservices.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Product {

	@Id
	private String productCode;
	@Column(name = "company_id")
	private String companyId;
	private String productDescription;
	private String productMrp;
	private int productPrice;
	private int productQuantity;
	
	public Product() {}
	
	public Product(String productCode, String companyId, String productDescription, String productMrp, int productPrice) {
		this.productCode = productCode;
		this.companyId = companyId;
		this.productDescription = productDescription;
		this.productMrp = productMrp;
		this.productPrice = productPrice;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getCompanyId() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productName) {
		this.productDescription = productName;
	}

	public String getProductMrp() {
		return productMrp;
	}

	public void setProductMrp(String productMrp) {
		this.productMrp = productMrp;
	}

	public int getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}

	public int getProductQuantity() {
		return productQuantity;
	}

	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}
	
	
	
}
