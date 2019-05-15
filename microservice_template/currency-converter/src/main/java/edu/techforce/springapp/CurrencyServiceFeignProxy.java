package edu.techforce.springapp;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="forex-service", serviceId = "forex-service")
@RibbonClient(name="forex-service")
public interface CurrencyServiceFeignProxy {
    @GetMapping("/currency-exchange/{from}/{to}")
    CurrencyConversionBean retrieveExchangeValue
            (@PathVariable("from") String from, @PathVariable("to") String to);
}
