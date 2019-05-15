package edu.techforce.springapp;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Component;

@Component
public class MockService{

    @HystrixCommand(fallbackMethod = "fallback_hello",
            commandProperties = {
                    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1000"),
                    @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value="60")
            })
    public String hello() throws InterruptedException {
        Thread.sleep(10000);
        return "Welcome Hystrix";
    }

    private String fallback_hello() {
        return "Request fails. It takes long time to response";
    }
}
