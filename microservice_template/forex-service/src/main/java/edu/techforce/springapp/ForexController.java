package edu.techforce.springapp;

import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class ForexController {
    private ExchangeValueService exchangeValueService;
    private Environment environment;

    ForexController(ExchangeValueService exchangeValueService, Environment environment) {
        this.environment = environment;
        this.exchangeValueService = exchangeValueService;
    }

    @GetMapping("currency-exchange/{from}/{to}")
    public ExchangeValue getExchangeRate(
            @PathVariable String from,
            @PathVariable String to) {
        ExchangeValue exchangeValue = exchangeValueService.getExchangeValueByFromAndTo(from, to);
        String portNumberInString = Optional.of(environment)
                .map(environment1 -> environment1.getProperty("local.server.port"))
                .orElse("8080");
        if(exchangeValue != null) {
            exchangeValue.setPort(Integer.parseInt(portNumberInString));
        }
        return exchangeValue;
    }
}

