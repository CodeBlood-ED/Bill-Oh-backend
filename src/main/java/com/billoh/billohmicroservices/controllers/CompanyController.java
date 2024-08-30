package com.billoh.billohmicroservices.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.billoh.billohmicroservices.models.Company;
import com.billoh.billohmicroservices.models.LoginDto;
import com.billoh.billohmicroservices.models.Product;
import com.billoh.billohmicroservices.repositories.CompanyRepository;
import com.billoh.billohmicroservices.repositories.CompanyWiseProductRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/company")
public class CompanyController {

	@Autowired
	CompanyRepository companyRepo;
	@Autowired
	CompanyWiseProductRepository productRepo;
	
	
	@PostMapping("/login")
	public String companyLogin(@RequestBody LoginDto loginDetails) {
		return "Company Found";
		
	}
	@GetMapping("/{id}")
	public Optional<Company> retrieveCompanyDetails(@PathVariable("id") Long id) {
		return companyRepo.findById(id);
		
	}
	
	@PostMapping("/add")
	public String addCompany(@RequestBody Company company) {

		company.setPass(company.getPass());
		companyRepo.save(company);
		return "Company added!";
	}
	
	@PostMapping("/{id}/add-product")
	public ResponseEntity<String> createProductAgainstCompany(@PathVariable("id") String companyId, @RequestBody Product product) {
		product.setCompanyId(companyId);
	    this.productRepo.save(product);
	    return ResponseEntity.status(HttpStatus.CREATED).body("Product added successfully");
	}
	
	@GetMapping("/{id}/get-products")
	public ResponseEntity<List<Product>> retrieveProductsAgainstCompany(@PathVariable("id") String companyId){
		List<Product>  products = this.productRepo.findAllProductsByCompanyId(companyId);
		if(null != products && products.size() > 0) {
			return ResponseEntity.status(HttpStatus.OK).body(products);
		}
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(products);
	}
}
