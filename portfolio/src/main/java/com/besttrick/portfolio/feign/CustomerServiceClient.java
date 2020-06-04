package com.besttrick.portfolio.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.besttrick.portfolio.model.CustomerDetail;

@FeignClient(name = "customer-service", url = "${customer.service.url}")
public interface CustomerServiceClient {

	@RequestMapping(value = { "/customer/getCustomer/{customerId}" }, method = RequestMethod.GET)
	public CustomerDetail getCustomerProfile(@PathVariable String customerId);
}
