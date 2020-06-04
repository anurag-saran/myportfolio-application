package com.besttrick.customer.model;

import java.util.ArrayList;
import java.util.List;

public class CustomerDetail {

	private String customerId;
	private String customerName;
	private String email;
	private String phone;
	private String profileImage;
	private List<String> stock = new ArrayList<>();

	public CustomerDetail() {
		super();
	}

	public CustomerDetail(String customerId, String customerName, String email, String phone, String profileImage,
			List<String> stock) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.email = email;
		this.phone = phone;
		this.profileImage = profileImage;
		this.stock = stock;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getProfileImage() {
		return profileImage;
	}

	public void setProfileImage(String profileImage) {
		this.profileImage = profileImage;
	}

	public List<String> getStock() {
		return stock;
	}

	public void setStock(List<String> stock) {
		this.stock = stock;
	}

}
