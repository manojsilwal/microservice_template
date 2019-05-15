package edu.techforce.springapp;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@RestController
@Slf4j
public class CurrencyConverionController {

    private RestTemplate restTemplate;
    private CurrencyServiceFeignProxy currencyServiceFeignProxy;
    private MockService mockService;

    CurrencyConverionController(RestTemplate restTemplate,
                                CurrencyServiceFeignProxy currencyServiceFeignProxy,
                                MockService mockService
    ){
        this.restTemplate = restTemplate;
        this.currencyServiceFeignProxy = currencyServiceFeignProxy;
        this.mockService = mockService;
    }

    @RequestMapping(value = "/hello-hystrix")
    public String helloMethod() throws InterruptedException {
        return mockService.hello();
    }

    @GetMapping("/currency-converter")
    public CurrencyConversionBean convertCurrency(@RequestParam String from,
                                                  @RequestParam String to,
                                                  @RequestParam BigDecimal quantity) {

        Map<String, String> uriVariables = new HashMap<>();
        uriVariables.put("from", from);
        uriVariables.put("to", to);

        //CurrencyConversionBean response = getCurrencyConversionBean(uriVariables);
        CurrencyConversionBean response = getFromFeignClient(from, to);

        return new CurrencyConversionBean(response.getId(), from, to, response.getConversionMultiple(), quantity,
                quantity.multiply(response.getConversionMultiple()), response.getPort());
    }

    private CurrencyConversionBean getCurrencyConversionBean(Map<String, String> uriVariables) {
        ResponseEntity<CurrencyConversionBean> responseEntity = restTemplate.getForEntity(
                "http://localhost:8000/currency-exchange/{from}/{to}", CurrencyConversionBean.class,
                uriVariables);

        return responseEntity.getBody();
    }

    private CurrencyConversionBean getFromFeignClient(String from, String to){
        return currencyServiceFeignProxy.retrieveExchangeValue(from, to);
    }
}
