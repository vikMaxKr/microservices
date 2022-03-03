package com.in28mins.microservices.microservicecurrencyconversion;

import java.math.BigDecimal;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CurrencyConversionController {
	
	@Autowired
	private CurrencyExchangeProxy  proxy;

	
	//rest call without feign proxy
	@GetMapping("/currency-conversion/from/{from}/to/{to}/qunatity/{quantity}")
	public Currencyconversion calculateCurencyConversion(
			@PathVariable String from,@PathVariable String to,
			@PathVariable BigDecimal quantity)
	{
		HashMap<String ,String> uriVariables=new HashMap<>();
		uriVariables.put("from", from);
		uriVariables.put("to", to);
		
		ResponseEntity<Currencyconversion> responseEntity=new RestTemplate()
				.getForEntity("http://localhost:8000/currency-exchange/from/{from}/to/{to}",
				Currencyconversion.class,uriVariables);
		
		  Currencyconversion currencyConversion=responseEntity.getBody();
		
		return new Currencyconversion(currencyConversion.getId(),
				from,to,quantity,currencyConversion.getConversionMultiple(),
				quantity.multiply(currencyConversion.getConversionMultiple()),
				currencyConversion.getEnvironment());
	}
	
	
	//using proxy
	@GetMapping("/currency-conversion-feign/from/{from}/to/{to}/qunatity/{quantity}")
	public Currencyconversion calculateCurencyConversionFeign(
			@PathVariable String from,@PathVariable String to,
			@PathVariable BigDecimal quantity)
	{
		
		  Currencyconversion currencyConversion=proxy.retrieveExchangeValue(from, to);
		
		return new Currencyconversion(currencyConversion.getId(),
				from,to,quantity,currencyConversion.getConversionMultiple(),
				quantity.multiply(currencyConversion.getConversionMultiple()),
				currencyConversion.getEnvironment());
	}
}
