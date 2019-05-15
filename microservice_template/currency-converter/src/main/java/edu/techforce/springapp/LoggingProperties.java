package edu.techforce.springapp;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@ConfigurationProperties("logging")
public class LoggingProperties {
    private Map<String, String> loggingCriteria;

    public Map<String, String> getLoggingCriteria() {
        return loggingCriteria;
    }

    public void setLoggingCriteria(Map<String, String> loggingCriteria) {
        this.loggingCriteria = loggingCriteria;
    }
}
