package com.billoh.billohmicroservices.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.billoh.billohmicroservices.models.Product;
import com.billoh.billohmicroservices.repositories.CompanyWiseProductRepository;

import jakarta.transaction.Transactional;

@RestController
public class ProductController {

	@Autowired
	CompanyWiseProductRepository prodRepo;

	@PostMapping("/getSearchedProduct")
	public ResponseEntity<Product> getSearchedProductDetails(@RequestParam String productCode) {
		Product productDetails = new Product();
		productDetails = this.prodRepo.findProductByProductCode(productCode);
		productDetails.setProductQuantity(1);
		return ResponseEntity.status(HttpStatus.OK).body(productDetails);
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@Transactional
	@PutMapping("/updateProduct")
	public ResponseEntity<String> updateSearchedProductDetails(@RequestParam String productDescription,
			@RequestParam String productCode, @RequestParam String productMrp, @RequestParam int productPrice) {
		this.prodRepo.updateProductByProductCode(productCode, productDescription, productMrp, productPrice);
		return ResponseEntity.status(HttpStatus.OK).body("Product updated");
	}
	
	@PostMapping("/addProduct")
	public ResponseEntity<String> addProduct(@RequestParam String productDescription,
			@RequestParam String productCode, @RequestParam String productMrp, @RequestParam int productPrice){
		Product productDetails = new Product();
		productDetails.setProductCode(productCode);
		productDetails.setProductDescription(productDescription);
		productDetails.setProductMrp(productMrp);
		productDetails.setProductPrice(productPrice);
		this.prodRepo.save(productDetails);
		return ResponseEntity.status(HttpStatus.OK).body("Product added succesfully");
	}
}
