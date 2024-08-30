package com.billoh.billohmicroservices.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.billoh.billohmicroservices.models.Product;

public interface CompanyWiseProductRepository extends JpaRepository<Product, String>{

	 @Query("select p from Product p where p.companyId = :companyId")
	 List<Product> findAllProductsByCompanyId(@Param("companyId") String companyId);
	
	 @Query("select p from Product p where p.productCode = :productCode")
	 public Product findProductByProductCode(@Param ("productCode") String productCode);
	 
	 @Modifying
	 @Query("UPDATE Product p SET p.productDescription = :productDescription, p.productMrp = :productMrp, p.productPrice = :productPrice WHERE p.productCode = :prodCode")
	 public Product updateProductByProductCode(
	         @Param("prodCode") String prodCode,
	         @Param("productDescription") String productDescription,
	         @Param("productMrp") String productMrp,
	         @Param("productPrice") int prodPrice);
	 
}
