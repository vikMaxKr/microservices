package com.in28mins.microservices.microservicecurrencyexchange;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrencyExchangeRepository extends
                      JpaRepository<CurrencyExchange,Long> {

	//adding extra method to jpa
	CurrencyExchange findByFromAndTo(String from,String to);
	
}
