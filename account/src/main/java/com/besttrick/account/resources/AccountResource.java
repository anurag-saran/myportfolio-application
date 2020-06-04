package com.besttrick.account.resources;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.besttrick.account.feign.PortFolioServiceClient;
import com.besttrick.account.feign.StockServiceClient;

@RestController
@RequestMapping("/account")
public class AccountResource {

	@Autowired
	StockServiceClient stockServiceClient;

	@Autowired
	PortFolioServiceClient portfolioRiskService;

	@SuppressWarnings("unchecked")
	@RequestMapping(value = { "/getAccountStatus/{userId}" }, method = RequestMethod.GET)
	public Map<String, Object> getSAccountStatus(@PathVariable String userId) {
		Map<String, Object> result = new LinkedHashMap<>();
		Map<String, Object> portData = portfolioRiskService.getRiskScore(userId);
		List<String> stockList = (List<String>) portData.get("stock");
		List<Map<String, Object>> stockPrice = new ArrayList<Map<String,Object>>();
		for(String stockSymbol : stockList) {
			stockPrice.add(stockServiceClient.getStockPrice(stockSymbol));			
		}		
		result.putAll(portData);
		result.put("stocks", stockPrice);
		System.out.println("Stock Price :- " + result);
		return result;
	}
}
