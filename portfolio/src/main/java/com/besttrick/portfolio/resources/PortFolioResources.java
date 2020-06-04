package com.besttrick.portfolio.resources;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.besttrick.portfolio.feign.CustomerServiceClient;
import com.besttrick.portfolio.model.CustomerDetail;

@RestController
@RequestMapping("/portfolioRisk")
public class PortFolioResources {

	@Autowired
	CustomerServiceClient customerService;

	@RequestMapping(value = { "/getRiskScore/{accountId}" }, method = RequestMethod.GET)
	public Map<String, Object> getRiskScore(@PathVariable String accountId) {
		Map<String, Object> returnMap = new LinkedHashMap<String, Object>();
		CustomerDetail customerDetail = customerService.getCustomerProfile(accountId);
		Random random = new Random();
		if (customerDetail == null) {
			List<String> dumStock = Arrays.asList("TCS", "IBM");
			String generatedString = "dum" + generatedString(2);
			returnMap.put("riskScore", random.nextInt(10));
			returnMap.put("name", new String(generatedString));
			returnMap.put("email", new String(generatedString + "@gmail.com"));
			returnMap.put("phone", new String("998" + random.nextInt(10000000)));
			returnMap.put("profileImage", "dummy.png");
			returnMap.put("stock", dumStock);
		} else {
			
			returnMap.put("riskScore", random.nextInt(10));			
			returnMap.put("name", customerDetail.getCustomerName());
			returnMap.put("email", customerDetail.getEmail());
			returnMap.put("phone", customerDetail.getPhone());
			returnMap.put("profileImage", customerDetail.getProfileImage());
			returnMap.put("stock", customerDetail.getStock());
		}
		return returnMap;
	}

	public String generatedString(int size) {
		int leftLimit = 97; // letter 'a'
		int rightLimit = 122; // letter 'z'
		Random random = new Random();
		String generatedString = random.ints(leftLimit, rightLimit + 1).limit(size)
				.collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString();

		System.out.println(generatedString);
		return generatedString;
	}
}
