//Feign client is used to reduce REST call codes 

package com.in28mins.microservices.microservicecurrencyconversion;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient(name="currency-exchange",url="localhost:8000")
@FeignClient(name="currency-exchange")
public interface CurrencyExchangeProxy {
	
	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public Currencyconversion retrieveExchangeValue(
			@PathVariable String from,@PathVariable String to);
	
}
