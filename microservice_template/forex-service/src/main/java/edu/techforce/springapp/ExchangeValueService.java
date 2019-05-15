package edu.techforce.springapp;

import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExchangeValueService {

    private ExchangeValueRepo exchangeValueRepo;

    ExchangeValueService( ExchangeValueRepo exchangeValueRepo){
        this.exchangeValueRepo = exchangeValueRepo;
    }

    public List<ExchangeValue> getAllExchangeValueWithExample(String from, String to){
        return exchangeValueRepo.findAll(Example.of(ExchangeValue.builder().from(from).to(to).build()));
    }

    public ExchangeValue getExchangeValueByFromAndTo(String from, String to){
        return exchangeValueRepo.findByFromAndTo(from, to);
    }

}
