package com.billoh.billohmicroservices.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.billoh.billohmicroservices.models.Company;

public interface CompanyRepository extends JpaRepository<Company, Long>{

	Company findDistinctByCompanyEmail(String companyEmail);

}
