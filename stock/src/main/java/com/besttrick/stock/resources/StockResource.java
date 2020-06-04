package com.besttrick.stock.resources;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stock")
public class StockResource {

	@RequestMapping(value = { "/getStockPrice/{stickSymbol}" }, method = RequestMethod.GET)
	public Map<String, Object> getStockPrice(@PathVariable String stickSymbol) {
		System.out.println("Stock Name :- " + stickSymbol);
		Random rand = new Random();
		int purchasePrice = rand.nextInt(1000);
		int currentPrice = rand.nextInt(1000);
		int units = rand.nextInt(10) + 1;
		Map<String, Object> map = new LinkedHashMap<>();
		map.put("stockName", stickSymbol);
		map.put("price", purchasePrice);
		map.put("currentPrice", currentPrice);
		map.put("units", units);
		map.put("value", currentPrice * units);
		if (purchasePrice < currentPrice) {
			int gain_loss = currentPrice - purchasePrice;
			int gp = (int) (((float)gain_loss / purchasePrice) * 100);
			System.out.println("Profit " + gain_loss + " ** " + gp + " ** " + ((float)gain_loss / purchasePrice));
			map.put("pandl", "+" + gp);
		} else {
			int gain_loss = purchasePrice - currentPrice;
			int gp = (int) (((float)gain_loss / purchasePrice) * 100);
			map.put("pandl", "-" + gp);
			System.out.println("Loss :" + gain_loss + " ** " + gp + " ** " + ((float)gain_loss / purchasePrice));
		}

		return map;
	}
}
