package com.besttrick.account.feign;

import java.util.Map;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "stock-service", url = "${stock-service-url}" )
public interface StockServiceClient {
	
	@RequestMapping(value = { "/stock/getStockPrice/{stickSymbol}" }, method = RequestMethod.GET)
	public Map<String, Object> getStockPrice(@PathVariable String stickSymbol);
}
