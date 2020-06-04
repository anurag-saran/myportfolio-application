package com.besttrick.customer.resources;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.besttrick.customer.model.CustomerDetail;

@RestController
@RequestMapping("/customer")
public class CustomerResources {

	static Map<String, CustomerDetail> customerDetails = new LinkedHashMap<String, CustomerDetail>();
	static {
		customerDetails.put("C001", new CustomerDetail("C001", "Mr. Daniel Callot", "Callot@gmail.com", "9876543210", "c001.jpg",
				Arrays.asList("IBM", "TCS", "Amazon")));
		customerDetails.put("C002", new CustomerDetail("C002", "Mr. Adam Young", "Young@yahoo.in", "9873214567", "c002.jpg",
				Arrays.asList("GOLD", "SILVER")));
		customerDetails.put("C003", new CustomerDetail("C003", "Mr. Anurag", "Saran@gmail.com", "9998885560", "c003.png",
				Arrays.asList("TELECOM", "TV", "FLIP")));
	}

	@RequestMapping(value = { "/getCustomer/{customerId}" }, method = RequestMethod.GET)
	public CustomerDetail getCustomerProfile(@PathVariable String customerId) {
		return customerDetails.get(customerId);
	}
}
