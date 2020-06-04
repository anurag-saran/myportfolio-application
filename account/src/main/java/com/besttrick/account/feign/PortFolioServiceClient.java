package com.besttrick.account.feign;

import java.util.Map;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "portfolio-service", url = "${portfolio-service-url}" )
public interface PortFolioServiceClient {

	@RequestMapping(value = { "/portfolioRisk/getRiskScore/{accountId}" }, method = RequestMethod.GET)
	public Map<String, Object> getRiskScore(@PathVariable String accountId);
}
