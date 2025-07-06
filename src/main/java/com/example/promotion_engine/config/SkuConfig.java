package com.example.promotion_engine.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Configuration
@ConfigurationProperties(prefix = "sku")
@Getter
@Setter
public class SkuConfig {
    private Map<String, Integer> prices;
}
