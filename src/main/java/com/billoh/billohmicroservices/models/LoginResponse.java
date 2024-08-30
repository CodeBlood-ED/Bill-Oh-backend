package com.billoh.billohmicroservices.models;

public class LoginResponse {
	private String companyEmail;
	private String password;
	
	LoginResponse(String email, String password){
		this.companyEmail = email;
		this.password = password;
	}

	public String getCompanyEmail() {
		return companyEmail;
	}

	public void setCompanyEmail(String companyEmail) {
		this.companyEmail = companyEmail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
